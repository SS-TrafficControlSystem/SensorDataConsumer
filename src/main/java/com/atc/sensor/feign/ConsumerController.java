package com.atc.sensor.feign;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ConsumerController {

    private final UnitManagementClient unitManagementClient;

    @GetMapping("/sensors")
    public List<Sensor> getAllCustomers() {
       return unitManagementClient.getAll();
    }
}
