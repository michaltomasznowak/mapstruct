package com.jlabs.mapstruct.web.controller;

import java.util.List;

import com.jlabs.mapstruct.service.facade.CarInfoFacade;
import com.jlabs.mapstruct.web.model.CarInfoEU;
import com.jlabs.mapstruct.web.model.CarInfoUS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/us/carinfo")
@RestController
public class USACarController {
    private final CarInfoFacade carInfoFacade;

    @Autowired
    public USACarController(CarInfoFacade carInfoFacade) {
        this.carInfoFacade = carInfoFacade;
    }

    @PostMapping
    public ResponseEntity<String> addCarInfo(@RequestBody CarInfoUS carInfoEU) {
        return new ResponseEntity<>(carInfoFacade.addCarInfoUS(carInfoEU), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarInfoUS> getCarInfo(@PathVariable("id") String id) {
        return new ResponseEntity<>(carInfoFacade.getCarsInfoUSById(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/")
    public ResponseEntity<List<CarInfoUS>> getEUCarInfo() {
        return new ResponseEntity<>(carInfoFacade.getCarsInfoUS(), HttpStatus.ACCEPTED);
    }
}
