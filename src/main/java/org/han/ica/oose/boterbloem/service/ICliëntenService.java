package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.domain.Client;

import java.util.List;

public interface ICliëntenService {
    /**
     *
     * @return method returns a list of all found cliënts
     */
    public List<Client> getAllCliënts();

}
