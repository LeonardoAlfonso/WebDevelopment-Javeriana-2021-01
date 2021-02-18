package com.javeriana.web.inventory.controllers;

import com.javeriana.web.inventory.services.UnitMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/unit")
public class UnitMeasurementController {

    private UnitMeasurementService unitMeasurementService;

    @Autowired
    public UnitMeasurementController(UnitMeasurementService unitMeasurementService){
        this.unitMeasurementService = unitMeasurementService;
    }



}
