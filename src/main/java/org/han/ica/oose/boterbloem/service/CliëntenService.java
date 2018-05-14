package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.domain.Client;

import java.util.List;

public class CliëntenService implements ICliëntenService {

    private CliëntenDAO cliëntenDAO = new CliëntenDAO;

    /**
     *
     * @return method returns a list of all found cliënts
     */
    @Override
    public List<Client> getAllCliënts() {
        return cliëntenDAO.getAllCliënten();
    }
}
