package org.han.ica.oose.boterbloem.domain.domainmappers;

import org.han.ica.oose.boterbloem.dataaccess.entities.ClientLimitationEntity;
import org.han.ica.oose.boterbloem.domain.domainobjects.Limitation;

public class LimitationMapper {

    public ClientLimitationEntity convertLimitation(Limitation limitation, int clientId) {
        ClientLimitationEntity limitationEntity = new ClientLimitationEntity();

        limitationEntity.setLimitation(limitation.getLimitation());
        limitationEntity.setClientId(clientId);

        return limitationEntity;
    }
}
