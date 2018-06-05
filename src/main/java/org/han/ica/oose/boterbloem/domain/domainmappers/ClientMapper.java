package org.han.ica.oose.boterbloem.domain.domainmappers;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IClientlimitationDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.ClientlimitationDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.ClientEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.UserEntity;
import org.han.ica.oose.boterbloem.domain.domainobjects.Address;
import org.han.ica.oose.boterbloem.domain.domainobjects.Client;
import org.han.ica.oose.boterbloem.domain.domainobjects.Limitation;

public class ClientMapper extends UserMapper {
    private IClientlimitationDAO clientlimitationDAO = new ClientlimitationDAOImpl();
    private LimitationMapper limitationMapper = new LimitationMapper();

    public Client extractClient(ClientEntity clientEntity) {
        Client client = new Client();

        Address address = new Address();
        address.setHouseNumber(clientEntity.getUserEntity().getHouseNumber());
        address.setResidence(clientEntity.getUserEntity().getResidence());
        address.setStreet(clientEntity.getUserEntity().getStreet());
        address.setZipCode(clientEntity.getUserEntity().getZipCode());

        client.setFirstName(clientEntity.getUserEntity().getFirstName());
        client.setLastName(clientEntity.getUserEntity().getLastName());
        client.setAddress(address);
        client.setDateOfBirth(clientEntity.getUserEntity().getDateOfBirth());
        client.setEmail(clientEntity.getUserEntity().getEmail());
        client.setPhoneNumber(clientEntity.getUserEntity().getPhoneNumber());
        client.setFirstTimeProfileCheck(clientEntity.getUserEntity().getFirstTimeProfileCheck());
        client.setPassword(clientEntity.getUserEntity().getPassword());


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

        return client;
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
}
