package com.atc.sensor.consumer;

import com.atc.sensor.dto.SensorDataDTO;
import com.atc.sensor.repository.ISensorDataRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ConsumerListener {

    private static final String TOPIC = "SensorData";
    private static final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private ISensorDataRepository iSensorDataRepository;

    @KafkaListener(topics = TOPIC, groupId = "group_id")
    public void listen(@Payload String payload) throws JsonProcessingException {
        log.info("Message received.  value {}", payload);
        //JsonDeserializer in properties not working
        iSensorDataRepository.save(mapper.readValue(payload, SensorDataDTO.class).getMongoEntity());
        log.info("Saved");
    }
}
