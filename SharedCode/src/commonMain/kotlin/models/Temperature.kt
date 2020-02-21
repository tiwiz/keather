package io.rob.keather.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Temperature(
    @SerialName("temp") val current: Float,
    @SerialName("feels_like") val feelsLike: Float,
    @SerialName("temp_min") val lowest: Float,
    @SerialName("temp_max") val highest: Float
)