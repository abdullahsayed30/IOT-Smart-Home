package org.ieee.iot.repository.sensors;

import org.ieee.iot.domain.sensors.TempHumSensorData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/*************************************************
 * Copyright (c) 2023-2-18 Abdullah Sayed Sallam.
 ************************************************/
@Repository
public interface DHT11SensorRepository extends MongoRepository<TempHumSensorData, Long> {
}
