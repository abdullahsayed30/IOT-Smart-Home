package org.ieee.iot.repository.sensors;

import org.ieee.iot.domain.sensors.DHT11SensorData;
import org.springframework.data.mongodb.repository.MongoRepository;


/*************************************************
 * Copyright (c) 2023-2-18 Abdullah Sayed Sallam.
 ************************************************/

public interface DHT11SensorRepository extends MongoRepository<DHT11SensorData, Long> {
}
