package org.han.ica.oose.boterbloem.domain.domainmappers;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IClientDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IClientlimitationDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.ClientDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.ClientlimitationDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.ClientEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.UserEntity;
import org.han.ica.oose.boterbloem.domain.domainobjects.Address;
import org.han.ica.oose.boterbloem.domain.domainobjects.Client;
import org.han.ica.oose.boterbloem.domain.domainobjects.Limitation;

public class ClientMapper extends UserMapper {
    private IClientlimitationDAO clientlimitationDAO = new ClientlimitationDAOImpl();
    private IClientDAO clientDAO = new ClientDAOImpl();
    private LimitationMapper limitationMapper = new LimitationMapper();

    public Client extractClient(ClientEntity clientEntity) {
        Client client = new Client();

        Address address = new Address();

        setAdressData(clientEntity, address);
        setClientPersonalDataOfClientEntity(clientEntity, client, address);
        setDataOfClientEntity(clientEntity, client);

        return client;
    }

    private void setAdressData(ClientEntity clientEntity, Address address) {
        address.setHouseNumber(clientEntity.getUserEntity().getHouseNumber());
        address.setResidence(clientEntity.getUserEntity().getResidence());
        address.setStreet(clientEntity.getUserEntity().getStreet());
        address.setZipCode(clientEntity.getUserEntity().getZipCode());
    }

    private void setClientPersonalDataOfClientEntity(ClientEntity clientEntity, Client client, Address address) {
        client.setFirstName(clientEntity.getUserEntity().getFirstName());
        client.setLastName(clientEntity.getUserEntity().getLastName());
        client.setAddress(address);
        client.setDateOfBirth(clientEntity.getUserEntity().getDateOfBirth());
        client.setEmail(clientEntity.getUserEntity().getEmail());
        client.setPhoneNumber(clientEntity.getUserEntity().getPhoneNumber());
        client.setFirstTimeProfileCheck(clientEntity.getUserEntity().getFirstTimeProfileCheck());
        client.setPassword(clientEntity.getUserEntity().getPassword());
    }

    private void setDataOfClientEntity(ClientEntity clientEntity, Client client) {
        client.setCompanion(clientEntity.getCompanion());
        client.setWarningPKB(clientEntity.isWarningPKB());
        client.setPkb(clientEntity.getPKB());
        client.setCompanionRequired(clientEntity.getCompanionRequired());
        client.setImage(clientEntity.getImage());
        client.setBankAccount(clientEntity.getBankAccount());

        for (String l : clientlimitationDAO.getByClientId(clientEntity.getClientId())) {
            Limitation limitation = new Limitation();
            limitation.setLimitation(l);
            client.addLimitation(limitation);
        }
    }

    public ClientEntity convertClient(Client client) {
        ClientEntity clientEntity = new ClientEntity();

        UserEntity userEntity = convertUser(client, client.getId());
        clientEntity.setUserEntity(userEntity);
        clientEntity.setCompanion(client.getCompanion());
        clientEntity.setWarningPKB(client.getWarningPkb());
        clientEntity.setPKB(client.getPkb());
        clientEntity.setCompanionRequired(client.getCompanionRequired());
        clientEntity.setImage(client.getImage());
        clientEntity.setBankAccount(client.getBankAccount());
        for (Limitation limitation : client.getLimitations()) {
            clientlimitationDAO.update(limitationMapper.convertLimitation(limitation, client.getId()));
        }

        return clientEntity;
    }

    /**
     * Setter for property 'clientlimitationDAO'.
     *
     * @param clientlimitationDAO Value to set for property 'clientlimitationDAO'.
     */
    public void setClientlimitationDAO(IClientlimitationDAO clientlimitationDAO) {
        this.clientlimitationDAO = clientlimitationDAO;
    }

    /**
     * Setter for property 'limitationMapper'.
     *
     * @param limitationMapper Value to set for property 'limitationMapper'.
     */
    public void setLimitationMapper(LimitationMapper limitationMapper) {
        this.limitationMapper = limitationMapper;
    }

    public void setClientDAO(IClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }


}
