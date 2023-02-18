package org.ieee.iot.service.house;

import lombok.RequiredArgsConstructor;
import org.ieee.iot.domain.House;
import org.ieee.iot.domain.Room;
import org.ieee.iot.repository.HouseRepository;
import org.springframework.stereotype.Service;


/*************************************************
 * Copyright (c) 2023-2-18 Abdullah Sayed Sallam.
 ************************************************/

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {

    private final HouseRepository houseRepository;

    @Override
    public House createHouse(House house) {
        return houseRepository.save(house);
    }

    @Override
    public House createHouseForNewUser(String address) {
        House house = new House();
        house.setAddress(address);
        return houseRepository.save(house);
    }

    @Override
    public void addRoomToHouse(House house, Room room) {
        house.getRooms().add(room);
        houseRepository.save(house);
    }
}
