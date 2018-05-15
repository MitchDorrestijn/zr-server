package org.han.ica.oose.boterbloem.dao;

import org.han.ica.oose.boterbloem.domain.Client;

import java.sql.SQLException;
import java.util.List;

public interface ICliëntenDAO {
    /**
     * Requests a list of all current Cliënts from the database
     *
     * @return The list of Cliënts
     */
    List<Client> getAllCliënts() throws SQLException;

    Client getCliëntById(int id) throws SQLException;
}
