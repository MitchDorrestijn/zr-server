package org.han.ica.oose.boterbloem.configuration;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class for handling the database properties
 */
public class DatabaseConfig {
    private static final Logger LOGGER = Logger.getLogger(DatabaseConfig.class.getName());
    private static final String PROPERTIES_FILE_PATH = "database.properties";
    private static final String PROPERTIES_DRIVER_KEY = "dn";
    private static final String PROPERTIES_CONNECTION_STRING_KEY = "url";
    private static final String USER = "user";
    private static final String PASS = "pwd";

    private Properties properties;


    public DatabaseConfig() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream(getPropertiesFilePath()));
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Can't access properties file", e);
        }
    }

    public String getDriver() {
        return properties.getProperty(PROPERTIES_DRIVER_KEY);
    }

    public String getUser() {
        return properties.getProperty(USER);
    }

    public String getPass() {
        return properties.getProperty(PASS);
    }

    public String getPropertiesFilePath() {
        return PROPERTIES_FILE_PATH;
    }

    public String getConnectionString() {
        return properties.getProperty(PROPERTIES_CONNECTION_STRING_KEY);
    }
}