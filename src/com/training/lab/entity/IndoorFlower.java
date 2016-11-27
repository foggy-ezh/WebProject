package com.training.lab.entity;


public class IndoorFlower extends Flower{
    private GrowingTips growingTips;

    public void setGrowingTips(GrowingTips growingTips) {
        this.growingTips = growingTips;
    }

    public GrowingTips getGrowingTips() {
        return growingTips;
    }

    @Override
    public String toString() {
        return "IndoorFlower{" +super.toString()+
                "growingTips=" + growingTips +
                '}';
    }
}
