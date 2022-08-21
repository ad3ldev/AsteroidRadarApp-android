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

    val asteroids: MutableList<Asteroid> = listOf(
        Asteroid(12, "Asteroid1", "20-02-2022", 10.0, 10.0, 10.0, 10.0, true),
        Asteroid(13,"Asteroid2", "20-02-2022", 20.0, 20.0, 20.0, 20.0, false),
        Asteroid(14, "Asteroid3", "20-02-2022", 30.0, 30.0, 30.0, 30.0, true),
        Asteroid(12, "Asteroid4", "20-02-2022", 10.0, 10.0, 10.0, 10.0, true),
        Asteroid(13,"Asteroid5", "20-02-2022", 20.0, 20.0, 20.0, 20.0, false),
        Asteroid(14, "Asteroid6", "20-02-2022", 30.0, 30.0, 30.0, 30.0, true),
        Asteroid(12, "Asteroid7", "20-02-2022", 10.0, 10.0, 10.0, 10.0, true),
        Asteroid(13,"Asteroid8", "20-02-2022", 20.0, 20.0, 20.0, 20.0, false),
        Asteroid(14, "Asteroid9", "20-02-2022", 30.0, 30.0, 30.0, 30.0, true),
        Asteroid(12, "Asteroid10", "20-02-2022", 10.0, 10.0, 10.0, 10.0, true),
        Asteroid(13,"Asteroid11", "20-02-2022", 20.0, 20.0, 20.0, 20.0, false),
        Asteroid(14, "Asteroid12", "20-02-2022", 30.0, 30.0, 30.0, 30.0, true)
    ) as MutableList<Asteroid>

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