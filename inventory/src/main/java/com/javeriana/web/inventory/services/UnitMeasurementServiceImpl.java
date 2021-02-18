package com.javeriana.web.inventory.services;

import com.javeriana.web.inventory.models.UnitMeasurement;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnitMeasurementServiceImpl implements UnitMeasurementService {

    private List<UnitMeasurement> units;

    public UnitMeasurementServiceImpl() {
        this.units = new ArrayList<UnitMeasurement>();
        UnitMeasurement unit = new UnitMeasurement(1, "Unidad", "U", true);
        this.units.add(unit);
        unit = new UnitMeasurement(2, "Docena", "D", true);
        this.units.add(unit);
        unit = new UnitMeasurement(3, "Caja", "C", true);
        this.units.add(unit);
    }

    @Override
    public long addUnitMeasurement(UnitMeasurement unitMeasurement) throws Exception {
        if(this.validateId(unitMeasurement)) {
            this.units.add(unitMeasurement);
        }
        else {
            throw new Exception("UnitMeasurementService.addUnitMeasurement Causa: Id ya existe.");
        }
        return unitMeasurement.getId();
    }

    private boolean validateId(UnitMeasurement unitMeasurement) {
        boolean exist = true;
        for(int i=0; i<this.units.size(); i++) {
            if(this.units.get(i).getId() == unitMeasurement.getId()) {
                exist = false;
                i = this.units.size();
            }
        }
        return exist;
    }

    @Override
    public UnitMeasurement getUnitMeasurement(long id) throws Exception{
        return null;
    }

    @Override
    public void updateUnitMeasurement(UnitMeasurement unitMeasurement, long id) throws Exception{

    }

    @Override
    public void deleteUnitMeasurement(long id) throws Exception{

    }

    @Override
    public List<UnitMeasurement> getAllUnitMeasurement() throws Exception{
        return this.units;
    }
}
