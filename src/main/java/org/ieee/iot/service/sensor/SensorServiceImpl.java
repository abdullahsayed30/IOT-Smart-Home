package org.ieee.iot.service.sensor;

import lombok.RequiredArgsConstructor;
import org.ieee.iot.db.sequence.SequenceGenerator;
import org.ieee.iot.domain.Place;
import org.ieee.iot.domain.sensors.PowerMeterSensorData;
import org.ieee.iot.domain.sensors.Sensor;
import org.ieee.iot.domain.sensors.SensorType;
import org.ieee.iot.domain.sensors.TempHumSensorData;
import org.ieee.iot.repository.sensors.SensorRepository;
import org.springframework.stereotype.Service;

/*************************************************
 * Copyright (c) 2023-2-21 Abdullah Sayed Sallam.
 ************************************************/
@Service
@RequiredArgsConstructor
public class SensorServiceImpl implements SensorService {

    private final SequenceGenerator sequenceGenerator;
    private final SensorRepository sensorRepository;

    @Override
    public Sensor createSensor(String name, String description, SensorType type, Place place) {
        Long id = sequenceGenerator.generateSequence(Sensor.SEQ_NAME);
        Sensor sensor = new Sensor(id, name, description, type, place);
        return sensorRepository.save(sensor);
    }

    @Override
    public TempHumSensorData addTempHumSensorReading(Sensor sensor, Integer temperature, Integer humidity) {
        return null;
    }

    @Override
    public TempHumSensorData getTempHumSensorReading(Sensor sensor) {
        return null;
    }

    @Override
    public PowerMeterSensorData addPowerMeterSensorReading(Sensor sensor, Integer power) {
        return null;
    }

    @Override
    public PowerMeterSensorData getPowerMeterSensorReading(Sensor sensor) {
        return null;
    }
}
