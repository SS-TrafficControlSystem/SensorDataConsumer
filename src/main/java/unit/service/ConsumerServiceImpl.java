package unit.service;

import com.atc.sensor.dto.SensorDataDTO;
import com.atc.sensor.model.SensorType;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unit.client.Sensor;
import unit.client.UnitManagementClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ConsumerServiceImpl implements ConsumerService{

    @Autowired
    private UnitManagementClient unitManagementClient;
    private static Map<Long, SensorDataDTO> sensorDataDTOMap = new HashMap<>();

    @Override
    public List<SensorDataDTO> getAll() {
        return (sensorDataDTOMap.isEmpty()) ? new ArrayList<>() : sensorDataDTOMap.values().stream().toList();
    }

    @Override
    public SensorDataDTO getById(Long id) {
        return sensorDataDTOMap.get(id);
    }

    @PostConstruct
    public void initialize() {
        if(sensorDataDTOMap != null && sensorDataDTOMap.isEmpty()){
            List<Sensor> sensors = unitManagementClient.getAll();
            sensors.forEach(sensor -> sensorDataDTOMap.putIfAbsent(sensor.getId(),  mapper(sensor)));
        }
    }

    private SensorDataDTO mapper(Sensor sensor) {
        SensorDataDTO sensorDataDTO = new SensorDataDTO();
        sensorDataDTO.setSensorId(sensor.getId().toString());
        sensorDataDTO.setSensorType(SensorType.valueOf(sensor.getType()));
        sensorDataDTO.setUnit(sensor.getUnit());
        return sensorDataDTO;
    }


}
