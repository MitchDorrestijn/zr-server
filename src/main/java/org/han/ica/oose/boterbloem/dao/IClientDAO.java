package org.han.ica.oose.boterbloem.dao;

import org.han.ica.oose.boterbloem.domain.Client;

public interface IClientDAO {

    /**
     * Adds a new Client to the database
     * @param client Client object which contains the data that will be added
     */
    void create(Client client);
}
