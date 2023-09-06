package com.example.nortaltesttask.domain.usecases

import com.example.nortaltesttask.data.models.MovieCategory
import com.example.nortaltesttask.domain.repositories.MoviesRepository

class LoadMoviesUseCase(
    private val moviesRepository: MoviesRepository
) {

    suspend operator fun invoke(): List<MovieCategory> {
        return moviesRepository.loadMovies()
    }
}