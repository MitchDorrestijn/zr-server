package org.han.ica.oose.boterbloem.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class ConnectionFactory {

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
        } catch (IOException ex){
            Logger.getLogger(String.valueOf(ConnectionFactory.class)).severe(ex.getMessage());
        }


        try {
            Class.forName(jcdbDriver);
            return DriverManager.getConnection(databaseURL, databaseUsername, databasePassword);
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }

        return null;
    }

}
