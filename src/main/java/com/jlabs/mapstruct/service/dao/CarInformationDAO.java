package com.jlabs.mapstruct.service.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import com.jlabs.mapstruct.service.domain.CarInfo;
import org.springframework.stereotype.Component;

@Component
public class CarInformationDAO {

    private static final Map<String, CarInfo> cars =  new HashMap<String, CarInfo>();

    public String addCarInfo(CarInfo carInfo){
        String id = UUID.randomUUID().toString();
        cars.put(id, carInfo);
        return id;
    }

    public CarInfo getCarInfoById(String carId){
       return cars.get(carId);
    }

    public List<CarInfo> getCarInfos(){
        return new ArrayList<>(cars.values());
    }
}
