package org.ieee.iot.service.house;

import org.ieee.iot.domain.House;
import org.ieee.iot.domain.Room;


/*************************************************
 * Copyright (c) 2023-2-18 Abdullah Sayed Sallam.
 ************************************************/

public interface HouseService {
    House createHouseForNewUser(String address);

    House createHouse(House house);

    void addRoomToHouse(House house, Room room);
}
