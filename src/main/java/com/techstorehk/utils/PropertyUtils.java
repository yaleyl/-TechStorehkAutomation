package com.techstorehk.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtils {
    static Properties prop = new Properties();
    static final String FILE_PATH = "src/test/resources/config/config.properties";

    public static void loadProperties() {
        try {
            prop.load(new FileInputStream(FILE_PATH.replace("/", String.valueOf(File.separatorChar))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getPropertyByKey(String key) {
        return prop.getProperty(key);
    }

}
