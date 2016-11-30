package com.training.lab.entity;


public class OutdoorFlower extends Flower {
    private BloomingPeriodType bloomingPeriod;

    public BloomingPeriodType getBloomingPeriod() {
        return bloomingPeriod;
    }

    public void setBloomingPeriod(BloomingPeriodType bloomingPeriod) {
        this.bloomingPeriod = bloomingPeriod;
    }

    @Override
    public String toString() {
        return "OutdoorFlower{" + super.toString()+
                "bloomingPeriod=" + bloomingPeriod +
                '}';
    }
}
