package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.domain.Client;

import java.sql.SQLException;
import java.util.List;

public interface IClientservice {
    /**
     *
     * @return method returns a list of all found cliënts
     */
     List<Client> getAllCliënts() throws SQLException;

    /**
     *
     * @param id the clientId thats used for the query
     * @return A specific cliënt with the given id
     * @throws SQLException
     */
     Client findById(int id) throws SQLException;

}
