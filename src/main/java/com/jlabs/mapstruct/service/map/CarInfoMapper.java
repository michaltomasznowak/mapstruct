package com.jlabs.mapstruct.service.map;

import java.util.UUID;

import com.jlabs.mapstruct.service.domain.CarInfo;
import com.jlabs.mapstruct.web.model.CarInfoEU;
import com.jlabs.mapstruct.web.model.CarInfoUS;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CarInfoMapper {

    @Mapping(source = "insideCelsiusTemperature", target = "temp")
    @Mapping(source = "kilometersPerHour", target = "speed")
    @Mapping(source = "literTank", target = "tank")
    CarInfo mapToCarInfo(CarInfoEU carInfoEU);

    @InheritConfiguration
    @Mapping(source = "literTank", target = "tank", ignore = true)
    CarInfo mapToCarInfoWithoutTank(CarInfoEU carInfoEU);

    @Mapping(source = "insideFahrenheitTemperature", target = "temp", qualifiedByName = "temperatureCelsius")
    @Mapping(source = "milesPerHour", target = "speed", qualifiedByName = "miles")
    @Mapping(source = "gallonTank", target = "tank", qualifiedByName = "literTank")
    CarInfo mapToCarInfo(CarInfoUS carInfoUS);

    @Named("temperatureCelsius")
    default double fahrenheitToCelsius(double temperature) {
        return ((5 * (temperature - 32)) / 9);
    }

    @Named("miles")
    default double milesToKilometers(double miles) {
        return miles * 1.6;
    }

    @Named("literTank")
    default double gallonsToLiter(double gallons) {
        return gallons * 3.7854;
    }

    @AfterMapping
    default void setId(@MappingTarget CarInfo carInfo) {
        String id = UUID.randomUUID().toString();
        carInfo.setId(id);
    }

    @BeforeMapping
    default void checkSpeedEU(CarInfoEU carInfoEU) {
        if (carInfoEU.getKilometersPerHour() > 100) {
            System.out.println("To fats kilometers");
        }
    }

    @BeforeMapping
    default void checkSpeedUS(CarInfoUS carInfoUS) {
        if (carInfoUS.getMilesPerHour() > 60) {
            System.out.println("To fats miles");
        }
    }
}
