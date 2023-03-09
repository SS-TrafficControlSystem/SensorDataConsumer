package com.atc.sensor.repository;

import com.atc.sensor.model.SensorData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISensorDataRepository  extends MongoRepository<SensorData,String> {

   SensorData save(SensorData sensorData);

}
