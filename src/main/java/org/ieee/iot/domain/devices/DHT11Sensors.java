package org.ieee.iot.domain.devices;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "DHT11Sensors")
public class DHT11Sensors {

    private static final String SEQ_NAME = "DHT11Sensors_sequence";

    @Id
    private Long id;

    private Integer temp;
    private Integer humidity;

}
