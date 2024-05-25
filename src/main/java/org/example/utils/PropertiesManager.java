package org.example.utils;

import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Data
public class PropertiesManager {
    private static final Logger LOGGER = LogManager.getLogger();
    private Properties properties = new Properties();
    private static PropertiesManager INSTANCE = null;

    private PropertiesManager() {
        try {
            properties.load(new FileInputStream("src/main/resources/application.properties"));
        } catch (IOException e) {
            LOGGER.error("Не найден файл src/main/resources/application.properties");
        }
    }

    public static PropertiesManager getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new PropertiesManager();
        }
        return INSTANCE;
    }

}
