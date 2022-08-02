package com.luismir.kafka.model

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.errors.SerializationException
import org.apache.kafka.common.serialization.Serializer

class DriverSerializer: Serializer<Driver> {
    private val objectMapper = ObjectMapper()

    override fun serialize(topic: String?, data: Driver?): ByteArray? {
        return objectMapper.writeValueAsBytes(
            data ?: throw SerializationException("Error serializing Driver")
        )
    }

    override fun close() {}
}
