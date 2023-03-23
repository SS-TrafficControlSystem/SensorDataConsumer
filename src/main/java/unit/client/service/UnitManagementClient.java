package unit.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import unit.client.model.Sensor;

import java.util.List;


@FeignClient(value = "unitManagement", url = "http://localhost:8081")
public interface UnitManagementClient {


    @GetMapping("/sensors")
     List<Sensor> getAll();

    @GetMapping("/sensors/{id}")
     Sensor getById(@PathVariable Long id);

}
