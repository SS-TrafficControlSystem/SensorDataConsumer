package unit.client.model;

import lombok.Data;

@Data
public class Sensor {
    private Long id;

    private String type;

    private Unit unit;

}