package com.example.nortaltesttask.data.models

data class MovieCategory(
    val id: Int,
    val category: Int,
    val films: List<Film>
)

data class Film(
    val id: Int,
    val title: String,
    val poster: Int?
)