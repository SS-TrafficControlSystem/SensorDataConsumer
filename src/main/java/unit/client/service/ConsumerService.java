package unit.client.service;

import com.atc.sensor.dto.SensorDataDTO;

import java.util.List;

public interface ConsumerService {

     List<SensorDataDTO> getAll();

     SensorDataDTO getById(Long id);

}
