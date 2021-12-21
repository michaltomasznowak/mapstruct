package com.jlabs.mapstruct.service.map;

import com.jlabs.mapstruct.service.domain.CarInfo;
import com.jlabs.mapstruct.web.model.CarInfoEU;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface CarInfoEUMapper {

    @Mapping(source = "temp", target = "insideCelsiusTemperature")
    @Mapping(source = "speed", target = "kilometersPerHour")
    @Mapping(source = "tank", target = "literTank")
    CarInfoEU mapToCarInfoEU(CarInfo carInfo);

    @InheritInverseConfiguration
    CarInfo mapToCarInfo(CarInfoEU carInfoEU);
}
