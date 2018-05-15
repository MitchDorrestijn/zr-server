package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.dao.ClientDAO;
import org.han.ica.oose.boterbloem.domain.Client;

import java.sql.SQLException;
import java.util.List;

public class ClientService implements IClientservice {

    private ClientDAO clientDAO = new ClientDAO();

    /**
     *
     * @return method returns a list of all found clients
     */
    @Override
    public List<Client> getAllCliënts() throws SQLException {
        return clientDAO.getAllCliënts();
    }

    /**
     *
     * @param id the clientId thats used for the query
     * @return A specific clients with the given id
     * @throws SQLException
     */
    public Client findById(int id) throws SQLException {
        return clientDAO.getCliëntById(id);
    }

}
