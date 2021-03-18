package com.javeriana.web.inventory.services;

import com.javeriana.web.inventory.models.UnitMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitMeasurementRepository extends JpaRepository<UnitMeasurement, Long> {
    public UnitMeasurement getByName(String name);
}
