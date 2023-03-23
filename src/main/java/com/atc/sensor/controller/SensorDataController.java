package com.atc.sensor.controller;

import com.atc.sensor.model.SensorData;
import com.atc.sensor.service.SensorDataServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SensorDataController {

    @Autowired
    SensorDataServiceImpl sensorDataService;

    @GetMapping("/sensors")
    public List<SensorData> findAll() {
        return sensorDataService.getAll();
    }
}
