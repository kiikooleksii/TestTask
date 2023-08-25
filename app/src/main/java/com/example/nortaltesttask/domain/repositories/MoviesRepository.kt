package com.example.nortaltesttask.domain.repositories

import com.example.nortaltesttask.data.models.MovieCategory

interface MoviesRepository {

    suspend fun loadMovies(): List<MovieCategory>
}