package io.codelex.hierarchicalmapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<VehicleRecord, Long> {

    List<VehicleRecord> findAll();

    List<VehicleRecord> findAllByVehicleType(String type);
}
