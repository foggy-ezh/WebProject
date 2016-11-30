package com.training.lab.manager;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConfigurationManager {
    private static final String PATH_CONFIG = "properties.config";

    private ResourceBundle resourceBundle;

    public ConfigurationManager() {
        System.out.println(getClass().getProtectionDomain().getCodeSource());
        Properties prop = new Properties();
        try {
            prop.load(getClass().getClassLoader().getResourceAsStream("properties.config"));
            for (Map.Entry<Object, Object> o : prop.entrySet()) {
                System.out.print(o.getKey() + " = " + o.getValue());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        resourceBundle = ResourceBundle.getBundle(PATH_CONFIG);
    }

    public String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}