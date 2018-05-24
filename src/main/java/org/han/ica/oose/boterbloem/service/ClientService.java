package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.daoHibernate.*;
import org.han.ica.oose.boterbloem.entity.*;
import org.han.ica.oose.boterbloem.service.projection.ClientDetailDisplay;
import org.han.ica.oose.boterbloem.service.projection.CreateClientDisplay;

import java.util.logging.*;

import org.han.ica.oose.boterbloem.daoHibernate.ClientDAOImpl;
import org.han.ica.oose.boterbloem.daoHibernate.IClientDAO;
import org.han.ica.oose.boterbloem.entity.ClientEntity;
import org.han.ica.oose.boterbloem.service.projection.ClientDisplay;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class ClientService implements IClientservice {

    private static final Logger LOGGER = Logger.getLogger(ClientService.class.getName());
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("zorgrit");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    private IClientDAO clientDAO = new ClientDAOImpl(entityManager);
    private IUserDAO userDAO = new UserDAOImpl(entityManager);
    private IClientUtilityDAO clientUtilityDAO = new ClientUtilityDAO(entityManager);
    private IClientcareinstitutionDAO clientCareInstitutionDAO = new ClientcareinstitutionDAOImpl(entityManager);
    private IClientlimitationDAO clientlimitationDAO = new ClientlimitationDAOImpl(entityManager);


    public ClientService() {
        //Empty constructor
    }

    public void createClient(CreateClientDisplay createClientDisplay) {
        try {
            userDAO.add(createClientDisplay.getClientEntity().getUserEntity());
            clientDAO.add(createClientDisplay.getClientEntity());
            ClientUtilityEntity clientUtilityEntity = new ClientUtilityEntity();
            clientUtilityEntity.setClientId(createClientDisplay.getClientEntity().getClientId());
            clientUtilityEntity.setUtility(createClientDisplay.getUtility());
            clientUtilityDAO.add(clientUtilityEntity);


            for (String s : createClientDisplay.getLimitations()) {
                ClientLimitationEntity clientlimitationEntity = new ClientLimitationEntity();
                clientlimitationEntity.setClientId(createClientDisplay.getClientEntity().getClientId());
                clientlimitationEntity.setLimitation(s);
                clientlimitationDAO.add(clientlimitationEntity);
            }
        } catch ( Exception e ) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
    }

    /**
     * @return method returns a list of all found clients
     */
    public List <ClientDisplay> getAllClients() {
        List <ClientDisplay> clientDisplays = new ArrayList <>();
        try {
            List <ClientEntity> clientEntities = clientDAO.findAll();
            for (ClientEntity i : clientEntities) {
                double priceToPay = 0;
                boolean warningPKB = false;
                ClientDisplay clientDisplay = new ClientDisplay();
                clientDisplay.setClientId(i.getClientId());
                clientDisplay.setName(i.getUserEntity().getFirstName());
                clientDisplay.setPKB(i.getPKB());
                int distance = (i.getRideEntity().getDistance());
                if (distance > i.getPKB()) {
                    priceToPay = (i.getRideEntity().getDistance() * 0.005);
                    warningPKB = true;
                }
                clientDisplay.setTotalMeters(i.getRideEntity().getDistance());
                clientDisplay.setPriceToPay(priceToPay);
                clientDisplay.setWarningPKB(warningPKB);
                clientDisplays.add(clientDisplay);
            }
            return clientDisplays;
        } catch ( Exception e ) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return clientDisplays;
    }

    @Override
    public ClientEntity findById(int id) {
        try {
            return clientDAO.findById(id);
        } catch ( Exception e ) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return null;
    }

    @Override
    public void updateClient(ClientDetailDisplay clientDetailDisplay) {
        int clientId = clientDetailDisplay.getClient().getClientId();
        if(clientDetailDisplay.getClient() != clientDAO.findById(clientId)){
            clientDAO.update(clientDetailDisplay.getClient());
        } if(clientDetailDisplay.getLimitations() != clientlimitationDAO.getByClientId(clientId)){
            clientlimitationDAO.updateClientLimitations(clientDetailDisplay.getLimitations(), clientId);
        }
    }

    @Override
    public ClientDetailDisplay getClientDetails(int id){
        ClientDetailDisplay clientDetailDisplay = new ClientDetailDisplay();
        try{
            clientDetailDisplay.setClient(clientDAO.findById(id));
            clientDetailDisplay.setLimitations(clientlimitationDAO.getByClientId(id));
        }catch(Exception e){
            LOGGER.log(Level.SEVERE,e.getMessage());
        }

        return clientDetailDisplay;
    }

    @Override
    public int getCareInstitutionById(int id) {
        return (clientCareInstitutionDAO.getCareInstitutionId(id).getCareInstitutionId());
    }

    @Override
    public void deleteClient(int id, int idcare) {
        try {
            ClientcareinstitutionEntityPK clientcareinstitutionEntityPK = new ClientcareinstitutionEntityPK();
            clientcareinstitutionEntityPK.setCareInstitutionId(idcare);
            clientcareinstitutionEntityPK.setClientId(id);
            ClientcareinstitutionEntity clientcareinstitutionEntity = clientCareInstitutionDAO.find(clientcareinstitutionEntityPK);
            clientcareinstitutionEntity.setActive(false);
            clientCareInstitutionDAO.update(clientcareinstitutionEntity);
        } catch ( Exception e ) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
    }
}
