package org.ieee.iot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ieee.iot.domain.devices.Device;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;


/*************************************************
 * Copyright (c) 2023-2-18 Abdullah Sayed Sallam.
 ************************************************/

@Data
@AllArgsConstructor
@Document("rooms")
public class Room {

    @Transient
    public static final String SEQ_NAME = "rooms_sequence";

    @Id
    private Long id;

    @DocumentReference
    private House house;

    private String name;

    @DocumentReference
    private List<Device> devices;

}
