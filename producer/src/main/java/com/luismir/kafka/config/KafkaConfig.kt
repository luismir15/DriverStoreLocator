package com.luismir.kafka.config

import org.apache.kafka.clients.admin.AdminClientConfig
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.KafkaAdmin

/**
 * Kafka Configuration file to set up kafka properties
 *  server: where Kafka will be running
 *  topic: name of the topic will be working with
 */
@Configuration
open class KafkaConfig(
    @Value("\${kafka.bootstrapAddress}")
    private val server: String, //Kafka server
    @Value("\${kafka.topics.driver_location}")
    private val topic: String //topic to send events
) {

    /**
     * Bean of type KafkaAdmin to set the server which
     * Kafka will be running.
     *
     * @return new KafkaAdmin with prop.
     */
    @Bean
    open fun kafkaAdmin(): KafkaAdmin {
        val prop: MutableMap<String, Any?> = HashMap()
        prop[AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG] = server
        return KafkaAdmin(prop)
    }

    /**
     * Bean of type NewTopic with topic name, number of
     * partition and replication factor.
     *
     * @return new topic.
     */
    @Bean
    open fun driverLocation(): NewTopic {
        return NewTopic(topic, 1, 1.toShort())
    }
}
