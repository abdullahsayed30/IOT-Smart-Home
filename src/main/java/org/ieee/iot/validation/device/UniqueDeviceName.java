package org.ieee.iot.validation.device;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UniqueDeviceNameValidator.class)
public @interface UniqueDeviceName {
    String message() default "Device name must be unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
