package org.ieee.iot.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.ieee.iot.domain.devices.Device;
import org.ieee.iot.helper.req_model.NewDeviceModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/v1/devices")
@RestController
public class DeviceController {

//    private final DeviceService deviceService;

    @PostMapping
    public ResponseEntity<?> createDevice(@RequestBody @Valid NewDeviceModel newDevice) {


        return ResponseEntity.ok().body("Device created successfully.");

    }


    @GetMapping("{roomId}")
    public List<Device> getAllDevices(@PathVariable String roomId) {
        return null;
    }

    @GetMapping("/{deviceName}")
    public Device getDevice(@PathVariable String deviceName) {
        return null;
    }

    @PutMapping("/state/{deviceName}/{state:on|off}")
    public String updateDeviceState(@PathVariable("deviceName") String deviceName, @PathVariable String state) {
        boolean newState = state.equalsIgnoreCase("on");

//        deviceService.updateDeviceStateByName(deviceName, newState);
        return "Device state updated to " + state + " successfully.";
    }

}
