package org.ieee.iot.repository.sensors;

import org.ieee.iot.domain.sensors.PowerConsumptionSensorData;
import org.springframework.data.mongodb.repository.MongoRepository;


/*************************************************
 * Copyright (c) 2023-2-18 Abdullah Sayed Sallam.
 ************************************************/

public interface PowerConsSensorRepository extends MongoRepository<PowerConsumptionSensorData, Long> {
}
