package com.jlabs.mapstruct.service.facade;

import java.util.List;
import java.util.stream.Collectors;

import com.jlabs.mapstruct.service.dao.CarInformationDAO;
import com.jlabs.mapstruct.service.domain.CarInfo;
import com.jlabs.mapstruct.service.map.CarInfoEUMapper;
import com.jlabs.mapstruct.service.map.CarInfoMapper;
import com.jlabs.mapstruct.service.map.CarInfoUSMapper;
import com.jlabs.mapstruct.web.model.CarInfoEU;
import com.jlabs.mapstruct.web.model.CarInfoUS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarInfoFacade {

    private final CarInformationDAO carInformationDAO;
    private final CarInfoMapper carInfoMapper;
    private final CarInfoEUMapper carInfoEUMapper;
    private final CarInfoUSMapper carInfoUSMapper;

    @Autowired
    public CarInfoFacade(CarInformationDAO carInformationDAO, CarInfoMapper carInfoMapper,
                         CarInfoEUMapper carInfoEUMapper, CarInfoUSMapper carInfoUSMapper) {
        this.carInformationDAO = carInformationDAO;
        this.carInfoMapper = carInfoMapper;
        this.carInfoEUMapper = carInfoEUMapper;
        this.carInfoUSMapper = carInfoUSMapper;
    }

    public String addCarInfoUS(CarInfoUS carInfoUS) {
        CarInfo carInfo = carInfoMapper.mapToCarInfo(carInfoUS);
        return carInformationDAO.addCarInfo(carInfo);
    }

    public String addCarInfoEU(CarInfoEU carInfoEU) {
        CarInfo carInfo = carInfoMapper.mapToCarInfo(carInfoEU);
        return carInformationDAO.addCarInfo(carInfo);
    }

    public String addCarInfoUS(CarInfoEU carInfoUS) {
        CarInfo carInfo = carInfoMapper.mapToCarInfo(carInfoUS);
        return carInformationDAO.addCarInfo(carInfo);
    }

    public CarInfoEU getCarsInfoEUById(String id) {
        return carInfoEUMapper.mapToCarInfoEU(carInformationDAO.getCarInfoById(id));
    }

    public CarInfoUS getCarsInfoUSById(String id) {
        return carInfoUSMapper.mapToCarInfoUS(carInformationDAO.getCarInfoById(id));
    }

    public List<CarInfoEU> getCarsInfoEU() {
        return carInformationDAO.getCarInfos().stream()
                                .map(carInfoEUMapper::mapToCarInfoEU)
                                .collect(Collectors.toList());
    }

    public List<CarInfoUS> getCarsInfoUS() {
        return carInformationDAO.getCarInfos().stream()
                                .map(carInfoUSMapper::mapToCarInfoUS)
                                .collect(Collectors.toList());
    }
}
