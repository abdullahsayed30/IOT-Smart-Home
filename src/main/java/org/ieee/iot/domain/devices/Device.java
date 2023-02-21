package org.ieee.iot.domain.devices;

import lombok.*;
import org.ieee.iot.domain.BaseDocument;


/*************************************************
 * Copyright (c) 2023-2-18 Abdullah Sayed Sallam.
 ************************************************/

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Device extends BaseDocument {

    private String name;
    private String description;

    public Device(Long id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }
}
