package org.han.ica.oose.boterbloem.mapper;

import org.han.ica.oose.boterbloem.daoHibernate.*;
import org.han.ica.oose.boterbloem.entity.DriverEntity;
import org.han.ica.oose.boterbloem.service.displays.ClientDisplay;
import org.han.ica.oose.boterbloem.service.displays.DriverDisplay;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientMapper {
    private static final Logger LOGGER = Logger.getLogger(ClientMapper.class.getName());

    /**
     * Get all the clients from a specific care institution
     * @return a list of information from the clients of a specific care institution
     */
    public List<ClientDisplay> getAllClientsFromASpecificCareInstitution(int id){
        List<ClientDisplay> returnList = new ArrayList<>();
        try {
            //TODO methode
        } catch (Exception e){
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return returnList;
    }

}
