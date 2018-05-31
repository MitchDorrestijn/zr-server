package org.han.ica.oose.boterbloem.dataAccess.daoHibernate;

import org.han.ica.oose.boterbloem.dataAccess.daoHibernate.daoGeneric.IGenericDAO;
import org.han.ica.oose.boterbloem.dataAccess.entities.ClientEntity;

import java.util.List;

public interface IClientDAO extends IGenericDAO<ClientEntity> {
    void removeById(int clientId);

    /**
     * @param id id of the careinstitution
     * @return a list of clients from a specific care institution
     */
    List<ClientEntity> getByCareInstitutionId(int id);
}
