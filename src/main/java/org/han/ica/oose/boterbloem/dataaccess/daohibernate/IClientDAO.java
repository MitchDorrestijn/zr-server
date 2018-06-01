package org.han.ica.oose.boterbloem.dataaccess.daohibernate;

import org.han.ica.oose.boterbloem.dataaccess.entities.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daogeneric.*;

import java.util.List;

public interface IClientDAO extends IGenericDAO <ClientEntity> {
    void removeById(int clientId);

    /**
     * @param id id of the careinstitution
     * @return a list of clients from a specific care institution
     */
    List <ClientEntity> getByCareInstitutionId(int id);
}
