package org.han.ica.oose.boterbloem.database;

import org.han.ica.oose.boterbloem.dao.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

    private static final Logger LOGGER = Logger.getLogger(DAO.class.getName());

    private ConnectionFactory() {
        // Empty constructor to hide the implicit public one
    }

    public static Connection getConnection() throws SQLException {
        String databaseURL = null;
        String jcdbDriver = null;
        String databaseUsername = null;
        String databasePassword = null;

        try {
            InputStream stream = ConnectionFactory.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(stream);

            databaseURL = properties.getProperty("databaseURL");
            databaseUsername = properties.getProperty("databaseUsername");
            databasePassword = properties.getProperty("databasePassword");
            jcdbDriver = properties.getProperty("jcdbDriver");
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "There is a problem connecting to the database ", ex);

        }


        try {
            Class.forName(jcdbDriver);
            return DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }

        return null;
    }

}
