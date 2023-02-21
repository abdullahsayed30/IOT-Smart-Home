package org.ieee.iot.service.sensor;

import org.ieee.iot.domain.Place;
import org.ieee.iot.domain.sensors.PowerMeterSensorData;
import org.ieee.iot.domain.sensors.Sensor;
import org.ieee.iot.domain.sensors.SensorType;
import org.ieee.iot.domain.sensors.TempHumSensorData;

/*************************************************
 * Copyright (c) 2023-2-19 Abdullah Sayed Sallam.
 ************************************************/

public interface SensorService {
    Sensor createSensor(String name, String description, SensorType type, Place place);

    TempHumSensorData addTempHumSensorReading(Sensor sensor, Integer temperature, Integer humidity);

    TempHumSensorData getTempHumSensorReading(Sensor sensor);

    PowerMeterSensorData addPowerMeterSensorReading(Sensor sensor, Integer power);
    PowerMeterSensorData getPowerMeterSensorReading(Sensor sensor);

}
