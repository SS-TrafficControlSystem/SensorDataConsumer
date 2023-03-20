package unit.client;

import com.atc.sensor.dto.SensorDataDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import unit.service.ConsumerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ConsumerController {

    @Autowired
    private final ConsumerService consumerService;

    @GetMapping("/sensors")
    public List<SensorDataDTO> getAllCustomers() {
       return consumerService.getAll();
    }

    @GetMapping("/sensors/{id}")
    public SensorDataDTO getAllCustomersById(@PathVariable Long id) {
        return consumerService.getById(id);
    }
}
