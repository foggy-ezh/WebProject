package com.training.lab.constant;


public enum FlowersStructure {
    FLOWERS("flowers"),
    OUTDOOR_FLOWER("outdoor-flower"),
    INDOOR_FLOWER("indoor-flower"),
    NAME("name"),
    ORIGIN("origin"),
    SOIL("soil"),
    PARAMETERS("parameters"),
    STEM_COLOR("stem-color"),
    LEAF_COLOR("leaf-color"),
    AVG_SIZE("avg-size"),
    MULTIPLYING("multiplying"),
    GROWING_TIPS("growing-tips"),
    TEMPERATURE("temperature"),
    REQUIRED_LIGHTING("required-lighting"),
    WATER_NEED("water-need"),
    BLOOMING_PERIOD("blooming-period");

    private String value;

    FlowersStructure(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
