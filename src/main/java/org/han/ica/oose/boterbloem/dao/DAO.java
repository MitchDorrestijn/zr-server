package org.han.ica.oose.boterbloem.dao;

import org.han.ica.oose.boterbloem.configuration.DatabaseConfig;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;

/**
 * Class for establishing, handling and closing the database connection
 */
public class DAO implements IDAO {

    private static final Logger LOGGER = Logger.getLogger(DAO.class.getName());
    protected static final int VALID_CONNECTION_TIMEOUT = 2;
    protected Connection connection;

    public DAO() {
        DatabaseConfig databaseConfig = new DatabaseConfig();
        loadDatabaseDriver(databaseConfig.getDriver());
        makeConnection(databaseConfig);
    }

    /**
     * {@inheritDoc}
     */
    public PreparedStatement getPreparedStatement(String query) throws SQLException {
        return connection.prepareStatement(query);
    }

    /**
     * {@inheritDoc}
     */
    public void closeConnection() {
        try {
            getConnection().close();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "There is a problem closing the database connection", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean hasConnection() {
        try {
            getConnection().isValid(VALID_CONNECTION_TIMEOUT);
            return true;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Problem with database connection", e);
            return false;
        }
    }


    /**
     * Establishes the connection with the database
     *
     * @param databaseConfig The configuration settings of the database
     */
    private void makeConnection(DatabaseConfig databaseConfig) {

        try {
            if (databaseConfig.getUser() == null || databaseConfig.getPass() == null) {
                connection = (DriverManager.getConnection(databaseConfig.getConnectionString()));
            } else {
                System.out.println(databaseConfig.getConnectionString());
                System.out.println(databaseConfig.getUser());
                System.out.println(databaseConfig.getPass());
                connection = (DriverManager.getConnection(databaseConfig.getConnectionString(), databaseConfig.getUser(), databaseConfig.getPass()));
   //              connection = (DriverManager.getConnection("jdbc:mysql://localhost/zorgrit?useSSL=false","root","root")); //deze String trekt ie wel maar dat andere niet
//               connection = (DriverManager.getConnection(databaseConfig.getConnectionString() + "user=" + databaseConfig.getUser() + "&password=" + databaseConfig.getPass()));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Couldn't connect to the database", e);
        }
    }

    /**
     * Loads the databasedriver based on a given String
     *
     * @param driver
     */
    private void loadDatabaseDriver(String driver) {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Couldn't find the database driver", e);
        }
    }

    /**
     * Returns the Connection
     *
     * @return
     */
    private Connection getConnection() {
        return connection;
    }

}
