//package org.ieee.iot.validation.device;
//
//import jakarta.validation.ConstraintValidator;
//import jakarta.validation.ConstraintValidatorContext;
//import org.ieee.iot.service.DeviceServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class UniqueDeviceNameValidator implements ConstraintValidator<UniqueDeviceName, Object> {
//
//    @Autowired
//    private DeviceServiceImpl deviceService;
//
//    @Override
//    public boolean isValid(Object value, ConstraintValidatorContext context) {
//        deviceService.getAllDevices();
//
//        return false;
////        return !deviceRepository.existsByName((String) value);
//    }
//
//}
