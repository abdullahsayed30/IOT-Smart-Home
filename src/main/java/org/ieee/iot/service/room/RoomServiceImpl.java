package org.ieee.iot.service.room;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ieee.iot.db.sequence.SequenceGenerator;
import org.ieee.iot.domain.House;
import org.ieee.iot.domain.Room;
import org.ieee.iot.domain.User;
import org.ieee.iot.domain.devices.Device;
import org.ieee.iot.domain.devices.Light;
import org.ieee.iot.domain.sensors.Sensor;
import org.ieee.iot.helper.req_model.NewDeviceModel;
import org.ieee.iot.helper.req_model.NewRoomModel;
import org.ieee.iot.helper.req_model.NewSensorModel;
import org.ieee.iot.repository.RoomRepository;
import org.ieee.iot.service.device.DeviceService;
import org.ieee.iot.service.sensor.SensorService;
import org.ieee.iot.service.user.UserService;
import org.springframework.stereotype.Service;

import java.util.Objects;


/*************************************************
 * Copyright (c) 2023-2-18 Abdullah Sayed Sallam.
 ************************************************/

@Service
@RequiredArgsConstructor
@Slf4j
public class RoomServiceImpl implements RoomService {
    private final SequenceGenerator sequenceGenerator;
    private final RoomRepository roomRepository;
    private final UserService userService;
    private final DeviceService deviceService;
    private final SensorService sensorService;


    private void checkUserHasRoom(User user, Long roomId) {
        if (!userService.hasRoom(roomId, user)) {
            throw new RuntimeException("Room not found");
        }
    }

    @Override
    public Room createRoom(User user, NewRoomModel newRoomModel) {
        House house = user.getHouse();
        Long id = sequenceGenerator.generateSequence(Room.SEQ_NAME);
        Room room = new Room(id, newRoomModel.getName(), newRoomModel.getDescription(), house);

        return roomRepository.save(room);
    }

    @Override
    public Device addDeviceToRoom(User user, Long roomId, NewDeviceModel deviceModel) {
        checkUserHasRoom(user, roomId);

        // More device types will be added in the future
        switch (deviceModel.getType()) {
            case LIGHT:
                return addLightToRoom(user, roomId, deviceModel);
        }

        return null;
    }

    @Override
    public Sensor addSensorToRoom(User user, Long roomId, NewSensorModel sensorModel) {
        checkUserHasRoom(user, roomId);
        Room room = roomRepository.findById(roomId).orElseThrow();

        return sensorService.createSensor(
                sensorModel.getName(), sensorModel.getDescription(), sensorModel.getType(), room);
    }


    @Override
    public Light addLightToRoom(User user, Long roomId, NewDeviceModel deviceModel) {
        Room room = roomRepository.findById(roomId).orElseThrow();
        String name = deviceModel.getName();
        String description = Objects.requireNonNullElse(deviceModel.getDescription(), name + " On " + room.getName());

        return deviceService.createLight(name, description, room);
    }


}
