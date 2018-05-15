package org.han.ica.oose.boterbloem.dao;

import org.han.ica.oose.boterbloem.domain.Client;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientDAO implements IClientDAO {
    private static final Logger LOGGER = Logger.getLogger(ZorginstellingDAO.class.getName());
    public static final IConnectionDAO CONNECTION_DAO = new ConnectionDAO();

    public ClientDAO () {
        // empty constructor because of Spring
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void create(Client client) {
        try(PreparedStatement ps = CONNECTION_DAO.getPreparedStatement(
                "INSERT INTO Client VALUES(?, ?, ?, ?)")){
            ps.setInt(1, client.getClientId());
            ps.setString(2, client.getCompanion());
            ps.setString(3, client.getUtility());
            ps.setBoolean(4, client.isDriverPreferenceF());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Problem with creating a client", e);
        }
    }
}
