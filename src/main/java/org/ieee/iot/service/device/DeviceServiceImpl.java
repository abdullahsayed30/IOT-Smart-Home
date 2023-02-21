package org.ieee.iot.service.device;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ieee.iot.db.sequence.SequenceGenerator;
import org.ieee.iot.domain.Place;
import org.ieee.iot.domain.devices.Light;
import org.ieee.iot.repository.devices.LightRepository;
import org.springframework.stereotype.Service;

/*************************************************
 * Copyright (c) 2023-2-21 Abdullah Sayed Sallam.
 ************************************************/
@Service
@RequiredArgsConstructor
@Slf4j
public class DeviceServiceImpl implements DeviceService{

    private final SequenceGenerator sequenceGenerator;

    private final LightRepository lightRepository;

    @Override
    public Light createLight(String name, String description, Place place) {
        Long id = sequenceGenerator.generateSequence(Light.SEQ_NAME);
        Light light = new Light(id, name, description, place);
        return lightRepository.save(light);
    }
}
