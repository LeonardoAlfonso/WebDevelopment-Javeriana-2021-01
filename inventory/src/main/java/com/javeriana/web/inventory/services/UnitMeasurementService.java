package com.javeriana.web.inventory.services;

import com.javeriana.web.inventory.models.UnitMeasurement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UnitMeasurementService {

    public long addUnitMeasurement(UnitMeasurement unitMeasurement) throws Exception;
    public UnitMeasurement getUnitMeasurement(long id) throws Exception;
    public void updateUnitMeasurement(UnitMeasurement unitMeasurement, long id) throws Exception;
    public void deleteUnitMeasurement(long id) throws Exception;
    public List<UnitMeasurement> getAllUnitMeasurement() throws Exception;

}
