@file:Suppress("ArrayInDataClass")

package io.rob.keather

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Coords(
    @SerialName("lat") val latitude: Float,
    @SerialName("lon") val longitude: Float
)

@Serializable
data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)

@Serializable
data class Temperature(
    @SerialName("temp") val current: Float,
    @SerialName("feels_like") val feelsLike: Float,
    @SerialName("temp_min") val lowest: Float,
    @SerialName("temp_max") val highest: Float
)

@Serializable
data class WeatherResult(
    @SerialName("coord") val coordinates: Coords,
    @SerialName("weather") val forecast: Array<Weather>,
    @SerialName("main") val temperature: Temperature,
    val name: String
)