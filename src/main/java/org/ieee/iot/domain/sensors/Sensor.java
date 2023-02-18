package org.ieee.iot.domain.sensors;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ieee.iot.domain.BaseDocument;
import org.springframework.data.mongodb.core.mapping.Document;


/*************************************************
 * Copyright (c) 2023-2-18 Abdullah Sayed Sallam.
 ************************************************/

@Document("sensors")
@Data
@AllArgsConstructor
public class Sensor extends BaseDocument {

    private String name;
    private String description;
}
