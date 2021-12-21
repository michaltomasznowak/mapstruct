package com.jlabs.mapstruct.web.model;

public class CarInfoEU {

    private double insideCelsiusTemperature = 0;
    private double kilometersPerHour = 0;
    private int literTank = 0;

    public double getInsideCelsiusTemperature() {
        return insideCelsiusTemperature;
    }

    public void setInsideCelsiusTemperature(double insideCelsiusTemperature) {
        this.insideCelsiusTemperature = insideCelsiusTemperature;
    }

    public double getKilometersPerHour() {
        return kilometersPerHour;
    }

    public void setKilometersPerHour(double kilometersPerHour) {
        this.kilometersPerHour = kilometersPerHour;
    }

    public int getLiterTank() {
        return literTank;
    }

    public void setLiterTank(int literTank) {
        this.literTank = literTank;
    }
}
