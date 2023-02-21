package org.ieee.iot.repository.sensors;

import org.ieee.iot.domain.sensors.PowerMeterSensorData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/*************************************************
 * Copyright (c) 2023-2-18 Abdullah Sayed Sallam.
 ************************************************/
@Repository
public interface PowerConsSensorRepository extends MongoRepository<PowerMeterSensorData, Long> {
}
