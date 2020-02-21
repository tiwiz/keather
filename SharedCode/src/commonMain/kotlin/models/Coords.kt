package io.rob.keather.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Coords(
    @SerialName("lat") val latitude: Float,
    @SerialName("lon") val longitude: Float
)