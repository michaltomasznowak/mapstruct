package com.jlabs.mapstruct.service.map;

import com.jlabs.mapstruct.service.domain.CarInfo;
import com.jlabs.mapstruct.web.model.CarInfoEU;
import com.jlabs.mapstruct.web.model.CarInfoUS;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CarInfoMapperTest {

    @InjectMocks
    private CarInfoMapperImpl carInfoMapper;
    private CarInfoEU carInfoEU;
    private CarInfoUS carInfoUS;

    @BeforeAll
    public void  setUp(){
        carInfoEU = new CarInfoEU();
        carInfoEU.setLiterTank(10);
        carInfoEU.setInsideCelsiusTemperature(12);
        carInfoEU.setKilometersPerHour(25);

        carInfoUS = new CarInfoUS();
        carInfoUS.setGallonTank(10);
        carInfoUS.setMilesPerHour(30);
        carInfoUS.setInsideFahrenheitTemperature(60);
    }

    @Test
    void mapToCarInfo() {
        CarInfo carInfo = carInfoMapper.mapToCarInfo(carInfoEU);

        assertEquals(10, carInfo.getTank());
        assertEquals(25, carInfo.getSpeed());
        assertEquals(12, carInfo.getTemp());
        assertNotNull(carInfo.getId());
    }

    @Test
    void testMapToCarInfo() {
    }
}
