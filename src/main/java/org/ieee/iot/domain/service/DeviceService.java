package org.ieee.iot.domain.service;

import org.ieee.iot.domain.Device;
import java.util.List;

public interface DeviceService {

    List<Device> getAllDevices();

    Device getDeviceByName(String deviceName);

    Device createDevice(String deviceName, String deviceDescription);

    void updateDeviceStateByName(String deviceName, boolean state);
}
