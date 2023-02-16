package org.ieee.iot.domain.req;

import lombok.Data;

@Data
public class MqttMessage {
    private String topic;
    private String payload;
}
