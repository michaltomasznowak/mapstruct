package com.jlabs.mapstruct.web.model;

public class CarInfoUS {

    private double insideFahrenheitTemperature = 0;
    private double milesPerHour = 0;
    private double gallonTank = 0;

    public double getInsideFahrenheitTemperature() {
        return insideFahrenheitTemperature;
    }

    public void setInsideFahrenheitTemperature(double insideFahrenheitTemperature) {
        this.insideFahrenheitTemperature = insideFahrenheitTemperature;
    }

    public double getMilesPerHour() {
        return milesPerHour;
    }

    public void setMilesPerHour(double milesPerHour) {
        this.milesPerHour = milesPerHour;
    }

    public double getGallonTank() {
        return gallonTank;
    }

    public void setGallonTank(double gallonTank) {
        this.gallonTank = gallonTank;
    }
}
