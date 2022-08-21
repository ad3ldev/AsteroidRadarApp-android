package com.udacity.asteroidradar.main

import androidx.lifecycle.ViewModel
import com.udacity.asteroidradar.Asteroid

class MainViewModel : ViewModel() {
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
}