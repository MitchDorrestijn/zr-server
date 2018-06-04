package org.han.ica.oose.boterbloem.domain.domainmappers;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IClientlimitationDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.ClientlimitationDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.ClientEntity;
import org.han.ica.oose.boterbloem.domain.domainobjects.Client;
import org.han.ica.oose.boterbloem.domain.domainobjects.Limitation;

public class ClientMapper {
    private IClientlimitationDAO clientlimitationDAO = new ClientlimitationDAOImpl();
    private LimitationMapper limitationMapper = new LimitationMapper();

    public Client extractClient(ClientEntity clientEntity) {
        Client client = new Client();

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

        clientEntity.setCompanion(client.getCompanion());
        clientEntity.setWarningPKB(client.getWarningPkb());
        clientEntity.setPKB(client.getPkb());
        clientEntity.setCompanionRequired(client.getCompanionRequired());
        clientEntity.setImage(client.getImage());
        clientEntity.setBankAccount(client.getBankAccount());
        for(Limitation limitation : client.getLimitations()) {
            clientlimitationDAO.update(limitationMapper.convertLimitation(limitation, client.getId()));
        }

        return clientEntity;
    }
}
