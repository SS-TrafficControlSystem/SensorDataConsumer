package unit.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(value = "unitManagement", url = "http://localhost:8081")
public interface UnitManagementClient {


    @GetMapping("/sensors")
    public List<Sensor> getAll();

    @GetMapping("/sensors/{id}")
    public Sensor getById(@PathVariable Long id);

}
