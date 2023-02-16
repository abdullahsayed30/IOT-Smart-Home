package org.ieee.iot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@AllArgsConstructor
@Document("houses")
public class House {

    private String name;

    private String description;

    private String address;

    @DocumentReference
    private List<Room> rooms;

    @DocumentReference
    private List<Device> devices;


}
