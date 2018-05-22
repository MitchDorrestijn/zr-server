package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.daoHibernate.ClientDAOImpl;
import org.han.ica.oose.boterbloem.daoHibernate.IClientDAO;
import org.han.ica.oose.boterbloem.entity.ClientEntity;

import javax.persistence.*;
import java.util.*;

public class ClientService {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("zorgrit");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    private IClientDAO clientDAO  = new ClientDAOImpl(entityManager);

    public ClientService() {
        //Empty constructor
    }

    public void createClient(ClientEntity client) {
        clientDAO.add(client);
    }

    /**
     * @return method returns a list of all found clients
     */
    public List<ClientEntity> getAllClients() {
        return clientDAO.findAll();
    }

    /**
     * @param id the clientId thats used for the query
     * @return A specific clients with the given id
     */
    public ClientEntity findById(int id) {
        return clientDAO.findById(id);
    }

    public void update(ClientEntity client) {
        clientDAO.update(client);
    }

    public void deleteClient(int id) {
        clientDAO.removeById(id);
    }
}

