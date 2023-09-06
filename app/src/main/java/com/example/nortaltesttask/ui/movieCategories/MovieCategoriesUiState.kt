package com.example.nortaltesttask.ui.movieCategories

import com.example.nortaltesttask.data.models.Film
import com.example.nortaltesttask.data.models.MovieCategory

data class MovieCategoriesUiState(
    val movieCategories: List<MovieCategory> = emptyList(),
    val filteredList: List<Film> = emptyList()
)