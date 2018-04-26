package org.han.ica.oose.boterbloem.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DatabaseTestQuery {
    private Connection connection;

    public DatabaseTestQuery() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }

    /**
     * Deze class is een enorme code smell! Waar wordt dit voor gebruikt? want geen safe delete omdat het in een test wordt gebruikt. Waarom staat deze classe dan hier?
     * Moet je straks even naar kijken Mitch!?
     *
     */
    public String getCompanion() {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT companion FROM client WHERE clientId = ?");
            stmt.setInt(1, 2);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("companion");
                System.out.println(name); //Sven
            }
        } catch (SQLException ex) {
            Logger.getLogger(String.valueOf(DatabaseTestQuery.class)).severe(ex.getMessage());
        }
        return null;
    }
}
