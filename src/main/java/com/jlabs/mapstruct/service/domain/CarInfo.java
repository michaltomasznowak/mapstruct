package com.jlabs.mapstruct.service.domain;

import java.util.Objects;

public class CarInfo {

    private String id;
    private double temp = 0;
    private double speed = 0;
    private double tank = 0;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getTank() {
        return tank;
    }

    public void setTank(double tank) {
        this.tank = tank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarInfo carInfo = (CarInfo) o;
        return Double.compare(carInfo.temp, temp) == 0 && Double.compare(carInfo.speed, speed) == 0
            && Double.compare(carInfo.tank, tank) == 0 && Objects.equals(id, carInfo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, temp, speed, tank);
    }
}
