package unit.service;

import com.atc.sensor.dto.SensorDataDTO;

import java.util.List;

public interface ConsumerService {

    public List<SensorDataDTO> getAll();

    public SensorDataDTO getById(Long id);

}
