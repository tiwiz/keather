package io.rob.keather.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResult(
    @SerialName("coord") val coordinates: Coords,
    @SerialName("weather") val forecast: Array<Weather>,
    @SerialName("main") val temperature: Temperature,
    val name: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as WeatherResult

        if (coordinates != other.coordinates) return false
        if (!forecast.contentEquals(other.forecast)) return false
        if (temperature != other.temperature) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = coordinates.hashCode()
        result = 31 * result + forecast.contentHashCode()
        result = 31 * result + temperature.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }
}