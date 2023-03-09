package com.atc.sensor.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@ToString
@Document(collection = "sensorData")
public class SensorData {

    public SensorData(){}

    @Id
    private String sensorId;
    private SensorType sensorType;
    private LocalDateTime timestamp;
    private boolean available;
    private String dataValue;
}
