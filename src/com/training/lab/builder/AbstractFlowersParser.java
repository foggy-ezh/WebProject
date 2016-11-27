package com.training.lab.builder;

import com.training.lab.entity.Flower;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFlowersParser {
    private List<Flower> flowers = new ArrayList<>();

    public abstract void buildListFlowers(String fileName);

    public List<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(List<Flower> flowers){this.flowers= flowers;}
}
