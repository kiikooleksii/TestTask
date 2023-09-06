package com.example.nortaltesttask.di

import com.example.nortaltesttask.data.datasources.LocalCategories
import com.example.nortaltesttask.data.repositories.LocalMoviesRepositoryImpl
import com.example.nortaltesttask.domain.usecases.LoadMoviesUseCase

class AppContainer {

    private val localCategories = LocalCategories()
    private val repository = LocalMoviesRepositoryImpl(localCategories)

    val categoriesUseCase = LoadMoviesUseCase(repository)
}