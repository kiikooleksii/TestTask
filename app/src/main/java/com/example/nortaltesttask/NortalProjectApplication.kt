package com.example.nortaltesttask

import android.app.Application
import com.example.nortaltesttask.di.AppContainer

class NortalProjectApplication : Application() {

    val appContainer = AppContainer()
}