package com.udacity.asteroidradar.main

import androidx.lifecycle.ViewModel
import com.udacity.asteroidradar.Asteroid

class MainViewModel : ViewModel() {
    val asteroids: MutableList<Asteroid> = listOf(
        Asteroid(12, "Asteroid1", "20-02-2022", 10.0, 10.0, 10.0, 10.0, true),
        Asteroid(13,"Asteroid2", "20-02-2022", 20.0, 20.0, 20.0, 20.0, false),
        Asteroid(14, "Asteroid3", "20-02-2022", 30.0, 30.0, 30.0, 30.0, true)
    ) as MutableList<Asteroid>
}