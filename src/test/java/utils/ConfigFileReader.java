package utils;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {
     Properties properties;

    public ConfigFileReader() {
        BufferedReader reader;
        String filePath = "src/test/resources/config.properties";
        try {
            reader = new BufferedReader(new FileReader(filePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Config.properties not found at " + filePath);
        }
    }

    public String getConfigValue(String key) {
        return properties.getProperty(key);
    }
}
