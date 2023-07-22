package com.luismir.kafka.consumer.listener

import com.luismir.kafka.consumer.model.Driver
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import java.util.LinkedList

@Component
class KafkaListeners {

    private val events: HashMap<String, Driver> = HashMap();

    @KafkaListener(topics = ["driver_location"], groupId = "default")
    fun listener(data: Driver) {
        println(data);

        events[data.driverID] = data;
    }

    fun fetchEvents(n: Int): List<Driver> {
        return if (events.isEmpty()) {
            emptyList();
        } else {
            events.values.toList().takeLast(n);
        }
    }
}
