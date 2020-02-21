package io.rob.keather

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.rob.keather.models.WeatherResult
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json

@UnstableDefault
internal class WeatherApi {
    private val client = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(json = Json.nonstrict)
        }
    }

    suspend fun fetchWeather(city: String): WeatherResult {
        return client.get {
            url("$baseUrl//weather?q=$city&appid=$key")
        }
    }

    companion object {
        private const val baseUrl = "https://api.openweathermap.org/data/2.5"
        private const val key = "a7fdee84771593739d620b35d5386644"
    }
}