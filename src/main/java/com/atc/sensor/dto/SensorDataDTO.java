package com.atc.sensor.dto;

import com.atc.sensor.model.SensorData;
import com.atc.sensor.model.SensorType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import lombok.ToString;
import unit.client.Unit;

import java.time.LocalDateTime;

@Data
@ToString
public class SensorDataDTO {

public SensorDataDTO(){}

    private String sensorId;
    private SensorType sensorType;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime timestamp;
    private boolean available;
    private String dataValue;
    private Unit unit;

    public SensorData getMongoEntity(){
        SensorData sensorData = new SensorData();
        sensorData.setSensorId(this.sensorId);
        sensorData.setSensorType(this.sensorType);
        sensorData.setDataValue(this.dataValue);
        sensorData.setAvailable(this.available);
        sensorData.setTimestamp(this.timestamp);
        return sensorData;
    }

}
