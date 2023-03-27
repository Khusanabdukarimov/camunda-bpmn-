package org.natija.repository;

import org.natija.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface WarehouseRep extends JpaRepository<Warehouse, Integer> {
    Optional<Warehouse> findByName(String name);
}
