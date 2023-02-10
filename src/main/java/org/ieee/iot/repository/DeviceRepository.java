package org.ieee.iot.repository;

import org.ieee.iot.domain.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    Optional<Device> findByName(String deviceName);

    boolean existsByName(String deviceName);

}
