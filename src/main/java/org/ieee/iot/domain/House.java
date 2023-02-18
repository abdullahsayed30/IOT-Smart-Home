package org.ieee.iot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ieee.iot.domain.devices.Device;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import java.util.List;


/*************************************************
 * Copyright (c) 2023-2-18 Abdullah Sayed Sallam.
 ************************************************/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("houses")
public class House extends BaseDocument{

    private String name;
    private String description;
    private String address;

    @DocumentReference
    private List<Room> rooms;
    @DocumentReference
    private List<Device> devices;
}
