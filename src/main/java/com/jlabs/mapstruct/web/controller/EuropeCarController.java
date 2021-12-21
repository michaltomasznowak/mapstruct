package com.jlabs.mapstruct.web.controller;

import java.util.List;

import com.jlabs.mapstruct.service.facade.CarInfoFacade;
import com.jlabs.mapstruct.web.model.CarInfoEU;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/eu/carinfo")
@RestController
public class EuropeCarController {
    private final CarInfoFacade carInfoFacade;

    @Autowired
    public EuropeCarController(CarInfoFacade carInfoFacade) {
        this.carInfoFacade = carInfoFacade;
    }

    @PostMapping
    public ResponseEntity<String> addCarInfoEU(@RequestBody CarInfoEU carInfoEU) {
        return new ResponseEntity<>(carInfoFacade.addCarInfoEU(carInfoEU), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarInfoEU> getCarInfo(@PathVariable("id") String id) {
        return new ResponseEntity<>(carInfoFacade.getCarsInfoEUById(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/")
    public ResponseEntity<List<CarInfoEU>> getEUCarInfo() {
        return new ResponseEntity<>(carInfoFacade.getCarsInfoEU(), HttpStatus.ACCEPTED);
    }
}
