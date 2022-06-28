package com.epam.adrianna_bukowska.core_layer.calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {

    public static Properties property;
    private static String configPath = "src/main/resources/config.properties";
    private static Logger logger = LogManager.getLogger("logger");

    public static void initializePropertyFile() throws IOException {
        property= new Properties();
        InputStream readProperties = null;
        
        try {
            readProperties = new FileInputStream(configPath);
            property.load(readProperties);
        } catch (FileNotFoundException e) {
            logger.warn("Config file not found, can't proceed to test.", e);
            throw e;
        } catch (IOException e) {
            logger.warn(e.getMessage(), e);
            throw e;
        } finally {
            if (readProperties != null) {
                readProperties.close();
            }
        }
    }
}
