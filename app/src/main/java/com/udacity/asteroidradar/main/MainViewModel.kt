package com.udacity.asteroidradar.main

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.database.getDatabase
import com.udacity.asteroidradar.repository.AsteroidsRepository
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : ViewModel() {
    private val database = getDatabase(application)
    private val asteroidsRepository = AsteroidsRepository(database)

    init {
        viewModelScope.launch {
            asteroidsRepository.refreshAsteroids()
        }
    }

    val list = asteroidsRepository.asteroids

    private val _navigateToAsteroidDetails = MutableLiveData<Asteroid>()
    val navigateToAsteroidDetails
        get() = _navigateToAsteroidDetails
    fun onAsteroidClicked(asteroid: Asteroid) {
        _navigateToAsteroidDetails.value = asteroid
    }
    fun onAsteroidNavigated() {
        _navigateToAsteroidDetails.value = null
    }




}