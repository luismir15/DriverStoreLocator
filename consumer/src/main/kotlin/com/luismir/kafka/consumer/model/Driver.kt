package com.luismir.kafka.consumer.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Driver(
    @JsonProperty("driverID")
    val driverID: String,
    @JsonProperty("latitude")
    val latitude: Double,
    @JsonProperty("longitude")
    val longitude: Double
)
