package org.han.ica.oose.boterbloem.dao;

import org.han.ica.oose.boterbloem.domain.Client;
import org.han.ica.oose.boterbloem.domain.Zorginstelling;

import java.sql.SQLException;
import java.util.List;

public interface ICliëntenDAO {
    /**
     * Requests a list of all current Zorginstellingen from the database
     *
     * @return The list of Zorginstellingen
     */
    List<Client> getAllCliënts() throws SQLException;
}
