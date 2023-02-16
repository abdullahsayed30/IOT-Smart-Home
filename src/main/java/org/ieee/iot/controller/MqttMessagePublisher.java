package org.ieee.iot.controller;

import lombok.RequiredArgsConstructor;
import org.ieee.iot.domain.req.MqttMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/v1/publish")
@RestController
public class MqttMessagePublisher {

    private final MqttGateway mqttGateway;

    @PostMapping
    public void sendMessage(@RequestBody MqttMessage message) {
        mqttGateway.senToMqtt(message.getTopic(), message.getPayload());
    }

}
