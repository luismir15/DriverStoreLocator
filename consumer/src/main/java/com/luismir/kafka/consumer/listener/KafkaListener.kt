package com.luismir.kafka.consumer.listener

import com.luismir.kafka.consumer.model.Driver
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class KafkaListeners {

    @KafkaListener(topics = ["driver_location"], groupId = "default")
    fun listener(data: Driver) {
        println("listener received: $data")
    }
}

