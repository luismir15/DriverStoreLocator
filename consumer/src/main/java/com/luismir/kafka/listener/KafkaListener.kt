package com.luismir.kafka.listener

import com.luismir.kafka.model.Driver
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class KafkaListeners {

    @KafkaListener(topics = ["driver_location"], groupId = "default")
    fun listener(data: Driver) {
        println("listener received: $data")
    }
}

