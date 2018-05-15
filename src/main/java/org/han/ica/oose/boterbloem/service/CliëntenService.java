package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.dao.CliëntenDAO;
import org.han.ica.oose.boterbloem.domain.Client;

import java.sql.SQLException;
import java.util.List;

public class CliëntenService implements ICliëntenService {

    private CliëntenDAO cliëntenDAO = new CliëntenDAO();

    /**
     *
     * @return method returns a list of all found cliënts
     */
    @Override
    public List<Client> getAllCliënts() throws SQLException {
        return cliëntenDAO.getAllCliënts();
    }

    /**
     *
     * @param id the clientId thats used for the query
     * @return A specific cliënt with the given id
     * @throws SQLException
     */
    public Client findById(int id) throws SQLException {
        return cliëntenDAO.getCliëntById(id);
    }

}
