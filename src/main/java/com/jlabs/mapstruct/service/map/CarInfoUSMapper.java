package com.jlabs.mapstruct.service.map;

import com.jlabs.mapstruct.service.domain.CarInfo;
import com.jlabs.mapstruct.web.model.CarInfoUS;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel="spring")
public interface CarInfoUSMapper {
    @Mapping(source = "temp", target = "insideFahrenheitTemperature", qualifiedByName = "temperatureFahrenheit")
    @Mapping(source = "speed", target = "milesPerHour", qualifiedByName = "miles")
    @Mapping(source = "tank", target = "gallonTank", qualifiedByName = "gallonTank")
    CarInfoUS mapToCarInfoUS(CarInfo carInfo);

    @Named("temperatureFahrenheit")
    default double celsiusToFahrenheit(double temperature) {
        return (9.0/5.0) * temperature + 32;
    }

    @Named("miles")
    default double kilometersToMiles(double kilometers) {
        return kilometers / 1.6;
    }

    @Named("gallonTank")
    default double litersToGallons(double liters) {
        return liters / 3.7854;
    }
}
