package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.daoHibernate.ClientDAOImpl;
import org.han.ica.oose.boterbloem.daoHibernate.IClientDAO;
import org.han.ica.oose.boterbloem.entity.ClientEntity;
import org.han.ica.oose.boterbloem.service.projection.ClientDisplay;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

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
    public List<ClientDisplay> getAllClients() {
           List<ClientDisplay> clientDisplays = new ArrayList<>();

        List<ClientEntity> clientEntities = clientDAO.findAll();
        for (ClientEntity i : clientEntities){
            double priceToPay = 0;
            boolean warningPKB = false;
            ClientDisplay clientDisplay = new ClientDisplay();
            clientDisplay.setClientId(i.getClientId());
            clientDisplay.setName(i.getUserEntity().getFirstName());
            clientDisplay.setPKB(i.getPKB());
            int distance = (i.getRideEntity().getDistance());
            if (distance > i.getPKB()){
                priceToPay = (i.getRideEntity().getDistance() * 0.005);
                warningPKB = true;
            }
            clientDisplay.setTotalMeters(i.getRideEntity().getDistance());
            clientDisplay.setPriceToPay(priceToPay);
            clientDisplay.setWarningPKB(warningPKB);
            clientDisplays.add(clientDisplay);
        }
        return clientDisplays;
    }

    /**
     * @param id the clientId thats used for the query
     * @return A specific clients with the given id
     */
    public ClientEntity findById(int id) {
        return clientDAO.findById(id);
    }
}

