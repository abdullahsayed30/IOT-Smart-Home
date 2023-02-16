//package org.ieee.iot.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.ieee.iot.domain.Device;
//import org.ieee.iot.service.DeviceService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RequiredArgsConstructor
//@RequestMapping("/v1/devices")
//@RestController
//public class DeviceController {
//
//    private final DeviceService deviceService;
//
//    @PostMapping("/{deviceName}/{deviceDescription}")
//    public ResponseEntity<?> createDevice(@PathVariable String deviceName, @PathVariable String deviceDescription) {
//
//        try {
//            deviceService.createDevice(deviceName, deviceDescription);
//            return ResponseEntity.ok("Device " + deviceName + " created successfully.");
//        }
//        catch (Exception e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//
//    }
//
//
//    @GetMapping
//    public List<Device> getAllDevices() {
//        return deviceService.getAllDevices();
//    }
//
//    @GetMapping("/{deviceName}")
//    public Device getDevice(@PathVariable String deviceName) {
//        return deviceService.getDeviceByName(deviceName);
//    }
//
//    @PutMapping("/state/{deviceName}/{state:on|off}")
//    public String updateDeviceState(@PathVariable("deviceName") String deviceName, @PathVariable String state) {
//        boolean newState = state.equalsIgnoreCase("on");
//
//        deviceService.updateDeviceStateByName(deviceName, newState);
//        return "Device state updated to " + state + " successfully.";
//    }
//
//}
