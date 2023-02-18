package org.ieee.iot.service.room;

import org.ieee.iot.domain.Room;


/*************************************************
 * Copyright (c) 2023-2-18 Abdullah Sayed Sallam.
 ************************************************/

public interface RoomService {
    Room getRoom(Long id);
    Room createRoom(Room room);
    Room updateRoom(Room room);
}
