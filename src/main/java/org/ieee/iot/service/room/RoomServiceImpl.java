package org.ieee.iot.service.room;

import lombok.RequiredArgsConstructor;
import org.ieee.iot.domain.Room;
import org.ieee.iot.repository.RoomRepository;
import org.springframework.stereotype.Service;


/*************************************************
 * Copyright (c) 2023-2-18 Abdullah Sayed Sallam.
 ************************************************/

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService{

    private final RoomRepository roomRepository;

    @Override
    public Room getRoom(Long id) {
        return roomRepository.findById(id).orElseThrow();
    }

    @Override
    public Room createRoom(Room room) {
        return null;
    }

    @Override
    public Room updateRoom(Room room) {
        return null;
    }
}
