package com.atc.sensor.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient(value = "unitManagement", url = "http://localhost:8081")
public interface UnitManagementClient {


    @GetMapping("/sensors")
    public List<Sensor> getAll();

}
