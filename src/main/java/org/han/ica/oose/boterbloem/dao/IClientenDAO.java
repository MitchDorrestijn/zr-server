package org.han.ica.oose.boterbloem.dao;

import org.han.ica.oose.boterbloem.domain.Client;

import java.sql.SQLException;
import java.util.List;

public interface IClientenDAO {
    /**
     * Requests a list of all current Clients from the database
     *
     * @return The list of Clients
     */
    List<Client> getAllCliënts() throws SQLException;

    Client getCliëntById(int id) throws SQLException;
}
