package com.training.lab.entity;


public abstract class Flower {
    private String name;
    private String origin;
    private SoilType soil;
    private Parameters parameters;
    private MultiplyingType multiplying;

    public void setName(String name) {
        this.name = name;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setSoil(SoilType soil) {
        this.soil = soil;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setMultiplying(MultiplyingType multiplying) {
        this.multiplying = multiplying;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", soil=" + soil +
                ", parameters=" + parameters +
                ", multiplying=" + multiplying +
                '}';
    }
}