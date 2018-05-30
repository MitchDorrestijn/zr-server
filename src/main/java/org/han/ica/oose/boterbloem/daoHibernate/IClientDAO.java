package org.han.ica.oose.boterbloem.daoHibernate;

import org.han.ica.oose.boterbloem.daoHibernate.genericDao.IGenericDAO;
import org.han.ica.oose.boterbloem.entity.ClientEntity;

import java.util.List;

public interface IClientDAO extends IGenericDAO<ClientEntity> {
    void removeById(int clientId);

    /**
     * @param id id of the careinstitution
     * @return a list of clients from a specific care institution
     */
    List<ClientEntity> getByCareInstitutionId(int id);
}
