package com.udacity.asteroidradar.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.api.AsteroidApi.radar
import com.udacity.asteroidradar.api.parseAsteroidsJsonResult
import com.udacity.asteroidradar.database.AsteroidsDatabase
import com.udacity.asteroidradar.database.asDatabaseModel
import com.udacity.asteroidradar.database.asDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import timber.log.Timber

class AsteroidsRepository(private val database: AsteroidsDatabase) {

    val asteroids: LiveData<List<Asteroid>> =
        Transformations.map(database.asteroidDao.getAsteroids()) {
            it.asDomainModel()
        }

    suspend fun refreshAsteroids() {
        withContext(Dispatchers.IO) {
            try {
                val networkJson = radar.getAsteroidsAsync().await()
                val list = parseAsteroidsJsonResult(JSONObject(networkJson))
                database.asteroidDao.insertAll(*list.asDatabaseModel())
            } catch (e: Exception) {
                Timber.e(e.message)
            }
        }
    }
}