package com.javeriana.web.inventory.services;

import com.javeriana.web.inventory.models.UnitMeasurement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.javeriana.web.inventory.InventoryApplication.LOGGER;

@Service
public class UnitMeasurementServiceImpl implements UnitMeasurementService {

    private UnitMeasurementRepository repository;

    @Autowired
    public UnitMeasurementServiceImpl(UnitMeasurementRepository repository) {
        this.repository = repository;
    }

    @Override
    public UnitMeasurement addUnitMeasurement(UnitMeasurement unitMeasurement) throws Exception {
        try {
            unitMeasurement = this.repository.save(unitMeasurement);
        }
        catch (Exception e) {
            LOGGER.error("UnitMeasurementServiceImpl.addUnitMeasurement Causa: " + e.toString());
            throw new Exception("UnitMeasurementServiceImpl.addUnitMeasurement Causa: " + e.toString());
        }
        return unitMeasurement;
    }

    @Override
    public UnitMeasurement getUnitMeasurement(long id) throws Exception{
        UnitMeasurement unitMeasurement = null;
        try {
            unitMeasurement = this.repository.findById(id).get();
        }
        catch (Exception e) {
            LOGGER.error("UnitMeasurementServiceImpl.getUnitMeasurement Causa: " + e.toString());
            throw new Exception("UnitMeasurementServiceImpl.getUnitMeasurement Causa: " + e.toString());
        }
        return unitMeasurement;
    }

    @Override
    public void updateUnitMeasurement(UnitMeasurement unitMeasurement, long id) throws Exception{

    }

    @Override
    public void deleteUnitMeasurement(long id) throws Exception{

    }

    @Override
    public List<UnitMeasurement> getAllUnitMeasurement() throws Exception{
        List<UnitMeasurement> measurementsUnits = null;
        try {
            measurementsUnits = this.repository.findAll();
        }
        catch (Exception e) {
            LOGGER.error("UnitMeasurementServiceImpl.getAllUnitMeasurement Causa: " + e.toString());
            throw new Exception("UnitMeasurementServiceImpl.getAllUnitMeasurement Causa: " + e.toString());
        }
        return measurementsUnits;
    }
}
