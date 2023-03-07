package com.atc.sensor.consumer;

import com.atc.sensor.model.SensorData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ConsumerListener {

    private static final String TOPIC = "SensorData";

    @KafkaListener(topics = TOPIC, groupId = "group_id")
    public void listen(ConsumerRecord<String, SensorData> payload) {
        log.info("Message received. MessageID : {} Message: {} Date : {}, value {}",
                payload.key(), payload.headers(), payload.partition(), payload.value());
    }
}
