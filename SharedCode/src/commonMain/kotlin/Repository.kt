package io.rob.keather

import io.rob.keather.models.WeatherResult
import kotlinx.coroutines.launch
import kotlinx.serialization.UnstableDefault

@UnstableDefault
class Repository {
    private val scope = Scope()
    private val weatherApi = WeatherApi()

    fun fetchWeatherFor(city: String, callback: (WeatherResult) -> Unit) {
        scope.launch {
            val result = weatherApi.fetchWeather(city)
            callback(result)
        }
    }

    fun clear() {
        scope.job.cancel()
    }

}