package org.han.ica.oose.boterbloem.dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Interface for the main DAO Class
 */
public interface IDAO {
    /**
     * Closes the connection with the database if it hasn't already been closed
     */
    void closeConnection();

    /**
     * Returns a PreparedStatement based on a given String
     * @param query The query that will be returned as a PreparedStatement
     * @return The PreparedStatement
     * @throws SQLException
     */
    PreparedStatement getPreparedStatement(String query) throws SQLException;

    /**
     * Checks if there's already an active connection with the database
     * @return
     */
    Boolean hasConnection();
}