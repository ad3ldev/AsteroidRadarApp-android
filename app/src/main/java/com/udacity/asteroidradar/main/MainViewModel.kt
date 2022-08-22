package com.udacity.asteroidradar.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.PictureOfDay
import com.udacity.asteroidradar.api.AsteroidApi.radar
import com.udacity.asteroidradar.database.getDatabase
import com.udacity.asteroidradar.repository.AsteroidsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(application: Application) : ViewModel() {
    private val database = getDatabase(application)
    private val asteroidsRepository = AsteroidsRepository(database)

    init {
        viewModelScope.launch {
            asteroidsRepository.refreshAsteroids()
            getDayPicture()
        }
    }

    val list = asteroidsRepository.asteroids

    private val _pictureOfDay = MutableLiveData<PictureOfDay>()
    val pictureOfDay: LiveData<PictureOfDay>
        get() = _pictureOfDay

    private suspend fun getDayPicture() {
        withContext(Dispatchers.IO) {
            try {
                _pictureOfDay.postValue(radar.getPictureOfTheDay())
            } catch (err: Exception) {
                Log.e("refreshPictureOfDay", err.message.toString())
            }
        }
    }

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