package org.ieee.iot.domain.devices;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


/*************************************************
 * Copyright (c) 2023-2-18 Abdullah Sayed Sallam.
 ************************************************/

@Data
@AllArgsConstructor
@Document("lights")
public class Light extends Device {

    @Transient
    private final static String SEQ_NAME = "lights_sequence";

    private boolean state;

}
