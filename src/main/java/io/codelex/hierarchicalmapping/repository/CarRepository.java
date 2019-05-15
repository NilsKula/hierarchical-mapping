package io.codelex.hierarchicalmapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarRecord, String> {
}
