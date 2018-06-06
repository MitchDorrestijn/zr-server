package org.han.ica.oose.boterbloem.security;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class loads properties from from a file that have to do with the security of the application
 */
public class SecurityProperties {
    private static final Logger LOGGER = Logger.getLogger(JwtValidator.class.getName());

    /**
     * Gets the content of the application.properties file
     * @return the content of the application.prperties file
     */
    private InputStream getApplicationProperties() {
        return JwtGenerator.class.getClassLoader().getResourceAsStream("application.properties");
    }

    /**
     * Gets the signing and secret key from aplication.properties
     * @return the signing/secret key for JWT
     */
    public String getSigningkey(){
        String signKey = "";
        try {
            InputStream stream = getApplicationProperties();
            Properties prop = new Properties();
            prop.load(stream);
            signKey = prop.getProperty("secretkey");
        } catch (IOException e){
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return signKey;
    }

    /**
     * Gets the default antpattern that is used to secure url's
     * @return the default antpattern that is used to secure url's
     */
    public String getDefaultAntPattern(){
        String defaultAntPattern = "";
        try {
            InputStream stream = getApplicationProperties();
            Properties prop = new Properties();
            prop.load(stream);
            defaultAntPattern = prop.getProperty("defaultAntPattern");
        } catch (IOException e){
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return defaultAntPattern;
    }
}
