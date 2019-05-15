package io.codelex.hierarchicalmapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BikeRepository extends JpaRepository<BikeRecord, String> {

    List<BikeRecord> findAll();
}
