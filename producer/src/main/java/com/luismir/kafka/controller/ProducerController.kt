package com.luismir.kafka.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ProducerController(
    @Value("\${kafka.topics.driver_location}")
    private val topic: String,
    @Autowired
    private val kafkaTemplate: KafkaTemplate<String, Any>
) {

    @PostMapping
    fun publish(@Validated @RequestBody str: String){
        kafkaTemplate.send(topic, str)
    }
}