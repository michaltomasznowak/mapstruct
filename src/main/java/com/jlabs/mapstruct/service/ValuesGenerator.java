package com.jlabs.mapstruct.service;

import javax.annotation.PostConstruct;

import com.jlabs.mapstruct.service.dao.CarInformationDAO;
import com.jlabs.mapstruct.service.domain.CarInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValuesGenerator {

    private final CarInformationDAO carInformationDAO;

    @Autowired
    public ValuesGenerator(CarInformationDAO carInformationDAO) {
        this.carInformationDAO = carInformationDAO;
    }

    @PostConstruct
    public void init() {
        CarInfo carInfo1 = new CarInfo();
        carInfo1.setSpeed(100);
        carInfo1.setTemp(10);
        carInfo1.setTank(45);

        CarInfo carInfo2 = new CarInfo();
        carInfo2.setSpeed(60);
        carInfo2.setTemp(1);
        carInfo2.setTank(66);

        CarInfo carInfo3 = new CarInfo();
        carInfo3.setSpeed(88);
        carInfo3.setTemp(25);
        carInfo3.setTank(15);

        CarInfo carInfo4 = new CarInfo();
        carInfo4.setSpeed(150);
        carInfo4.setTemp(12);
        carInfo4.setTank(50);

        carInformationDAO.addCarInfo(carInfo1);
        carInformationDAO.addCarInfo(carInfo2);
        carInformationDAO.addCarInfo(carInfo3);
        carInformationDAO.addCarInfo(carInfo4);
    }
}
