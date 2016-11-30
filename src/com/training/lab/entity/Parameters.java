package com.training.lab.entity;


public class Parameters {
    private String stemColor;
    private String leafColor;
    private double avgSize;

    public String getLeafColor() {
        return leafColor;
    }

    public double getAvgSize() {
        return avgSize;
    }

    public String getStemColor() {
        return stemColor;
    }

    public void setStemColor(String stemColor) {
        this.stemColor = stemColor;
    }

    public void setLeafColor(String leafColor) {
        this.leafColor = leafColor;
    }

    public void setAvgSize(Double avgSize) {
        this.avgSize = avgSize;
    }

    @Override
    public String toString() {
        return "{" +
                "steamColor='" + stemColor + '\'' +
                ", leafColor='" + leafColor + '\'' +
                ", avgSize=" + avgSize +
                '}';
    }
}
