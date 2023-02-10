package org.ieee.iot.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.ieee.iot.validation.device.UniqueDeviceName;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class Device extends BaseEntity {

    @Column(columnDefinition = "varchar(255) unique")
    private String name;

    private String description;

    @Column(columnDefinition = "boolean default false")
    private boolean state;

}
