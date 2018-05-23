package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.daoHibernate.*;
import org.han.ica.oose.boterbloem.entity.ClientEntity;
import org.han.ica.oose.boterbloem.entity.ClientlimitationEntity;
import org.han.ica.oose.boterbloem.service.projection.CreateClientDisplay;

import javax.persistence.*;
import java.util.*;

public class ClientService {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("zorgrit");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    private IClientDAO clientDAO  = new ClientDAOImpl(entityManager);
    private IUserDAO userDAO = new UserDAOImpl(entityManager);
    private IClientlimitationDAO clientlimitationDAO = new ClientlimitationDAOImpl(entityManager);

    public ClientService() {
        //Empty constructor
    }

    public void createClient(CreateClientDisplay createClientDisplay) {
        userDAO.add(createClientDisplay.getClientEntity().getUserEntity());
        clientDAO.add(createClientDisplay.getClientEntity());
        for(String s : createClientDisplay.getLimitations()){
            ClientlimitationEntity clientlimitationEntity = new ClientlimitationEntity();
            clientlimitationEntity.setClientId(createClientDisplay.getClientEntity().getClientId());
            clientlimitationEntity.setLimitation(s);
            clientlimitationDAO.add(clientlimitationEntity);
        }
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

