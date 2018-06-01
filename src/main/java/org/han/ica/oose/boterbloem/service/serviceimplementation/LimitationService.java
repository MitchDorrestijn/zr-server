package org.han.ica.oose.boterbloem.service.serviceimplementation;

import org.han.ica.oose.boterbloem.service.*;
import org.han.ica.oose.boterbloem.dataaccess.entities.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.*;

import java.util.*;
import java.util.logging.*;

public class LimitationService implements ILimitationService {
    private static final Logger LOGGER = Logger.getLogger(LimitationService.class.getName());
    private ILimitationDAO limitationDAO = new LimitationDAOImpl();

    @Override
    public LimitationEntity getLimitationByName(String name) {
        try {
            return limitationDAO.findByName(name);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
            LimitationEntity limitationEntity = new LimitationEntity();
            limitationEntity.setName("Geen beperking gevonden met deze naam");
            return limitationEntity;
        }
    }

    @Override
    public List <LimitationEntity> getAllLimitations() {
        try {
            return limitationDAO.findAll();
        } catch (NullPointerException e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
            return new ArrayList<>();
        }
    }

    @Override
    public void addLimitation(LimitationEntity limitationEntity) {
        try {
            limitationDAO.add(limitationEntity);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
    }

    @Override
    public void updateLimitation(LimitationEntity limitationEntity) {
        try {
            limitationDAO.update(limitationEntity);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
    }

    @Override
    public void deleteLimitation(String name) {
        try {
            LimitationEntity limitationEntityToRemove = limitationDAO.findByName(name);
            limitationDAO.remove(limitationEntityToRemove);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
    }
}
