package com.main.demoproject.webuitesting.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {

    private static Properties properties;

    public static String readFromPropertiesFile(String key) throws IOException {
        File file = new File(System.getProperty("user.dir") + "//src//main//resources//configuration.properties");
        FileInputStream fin = new FileInputStream(file);
        properties = new Properties();
        properties.load(fin);
        String value = properties.getProperty(key);
        return value;
    }

}
