package com.example.nortaltesttask.ui.movieCategories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nortaltesttask.data.models.Film
import com.example.nortaltesttask.domain.usecases.LoadMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import kotlin.collections.ArrayList

class MoviesListViewModel(
    private val loadMoviesUseCase: LoadMoviesUseCase
) : ViewModel() {

    private val _categoriesListState = MutableStateFlow(MovieCategoriesUiState())

    val categoriesListState: StateFlow<MovieCategoriesUiState> = _categoriesListState

    private var filteredList: List<Film> = emptyList()
    private var nonFilteredList: List<Film> = emptyList()

    init {
        loadBooks()
    }

    private fun loadBooks() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _categoriesListState.update {
                    it.copy(
                        movieCategories = loadMoviesUseCase()
                    )
                }
            }
        }
    }

    fun updateNonFilterableFilmList(list: List<Film>) {
        nonFilteredList = list
    }

    fun search(query: String) {
        if (query.isNotEmpty()) {
            filteredList = onQueryChanged(query)
            updateFilmsList(filteredList)
        } else if (query.isEmpty()) {
            updateFilmsList(nonFilteredList)
        }
    }

    private fun onQueryChanged(filterQuery: String): List<Film> {
        val filteredList = ArrayList<Film>()
        for (film in nonFilteredList) {
            if (film.title.lowercase(Locale.getDefault()).contains(filterQuery)) {
                filteredList.add(film)
            }
        }
        return filteredList
    }

    private fun updateFilmsList(list: List<Film>) {
        _categoriesListState.update {
            it.copy(
                filteredList = list
            )
        }
    }
}