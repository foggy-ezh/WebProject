package com.training.lab.entity;


public class GrowingTips {
    private double temperature;
    private LightingType lightingType;
    private double waterNeed;

    public double getTemperature() {
        return temperature;
    }

    public LightingType getLightingType() {
        return lightingType;
    }

    public double getWaterNeed() {
        return waterNeed;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setLightingType(LightingType lightingType) {
        this.lightingType = lightingType;
    }

    public void setWaterNeed(double waterNeed) {
        this.waterNeed = waterNeed;
    }

    @Override
    public String toString() {
        return "GrowingTips{" +
                "temperature=" + temperature +
                ", lightingType=" + lightingType +
                ", waterNeed=" + waterNeed +
                '}';
    }
}
