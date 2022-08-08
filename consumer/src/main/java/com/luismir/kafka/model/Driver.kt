package com.luismir.kafka.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Driver(
    @JsonProperty("email")
    val email: String,
    @JsonProperty("latitude")
    val latitude: Double,
    @JsonProperty("longitude")
    val longitude: Double
)
