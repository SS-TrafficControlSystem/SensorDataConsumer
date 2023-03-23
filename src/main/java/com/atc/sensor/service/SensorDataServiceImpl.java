package com.atc.sensor.service;

import com.atc.sensor.model.SensorData;
import com.atc.sensor.repository.ISensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorDataServiceImpl implements ISensorDataService {

    @Autowired
    ISensorDataRepository iSensorDataRepository;

    @Override
    public List<SensorData> getAll() {
        return iSensorDataRepository.findAll();
    }
}
