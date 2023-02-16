package org.ieee.iot.domain.devices;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document("lights")
public class Lights {

    @Transient
    private final static String SEQ_NAME = "lights_sequence";

    @Id
    private Long id;


    private boolean state;

}
