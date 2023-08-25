package com.example.nortaltesttask.data.repositories

import com.example.nortaltesttask.data.datasources.LocalCategories
import com.example.nortaltesttask.data.models.MovieCategory
import com.example.nortaltesttask.domain.repositories.MoviesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalMoviesRepositoryImpl(
    private val localCategories: LocalCategories,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : MoviesRepository {

    override suspend fun loadMovies(): List<MovieCategory> {
        return withContext(dispatcher) {
            localCategories.createCategoriesList()
        }
    }
}