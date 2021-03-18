package com.javeriana.web.inventory.controllers;

import com.javeriana.web.inventory.models.UnitMeasurement;
import com.javeriana.web.inventory.services.UnitMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.javeriana.web.inventory.InventoryApplication.LOGGER;

@RestController
@RequestMapping(value = "/unit")
public class UnitMeasurementController {

    private UnitMeasurementService unitMeasurementService;

    @Autowired
    public UnitMeasurementController(UnitMeasurementService unitMeasurementService){
        this.unitMeasurementService = unitMeasurementService;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UnitMeasurement>> getUnits() {
        List<UnitMeasurement> units = null;
        HttpStatus codigo = HttpStatus.FORBIDDEN;
        try {
            units = this.unitMeasurementService.getAllUnitMeasurement();
            codigo = HttpStatus.OK;
        }
        catch (Exception e) {
            LOGGER.error("UnitMeasurementController.getUnits Cause: " + e.getMessage());
        }
        return new ResponseEntity<List<UnitMeasurement>>(units, codigo);
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UnitMeasurement> addUnitMeasurement(@RequestBody UnitMeasurement unitMeasurement) {
        HttpStatus codigo = HttpStatus.FORBIDDEN;
        long id = 0;
        try {
            unitMeasurement = this.unitMeasurementService.addUnitMeasurement(unitMeasurement);
            codigo = HttpStatus.OK;
        }
        catch (Exception e) {
            LOGGER.error("UnitMeasurementController.addUnitMeasurement Cause: " + e.getMessage());
        }
        return ResponseEntity.status(codigo).body(unitMeasurement);
    }

}
