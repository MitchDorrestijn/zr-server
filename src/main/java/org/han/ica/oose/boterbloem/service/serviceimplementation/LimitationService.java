package org.han.ica.oose.boterbloem.service.serviceimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.ILimitationDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.LimitationDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.LimitationEntity;
import org.han.ica.oose.boterbloem.service.ILimitationService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LimitationService implements ILimitationService {
    private static final Logger LOGGER = Logger.getLogger(LimitationService.class.getName());
    private ILimitationDAO limitationDAO = new LimitationDAOImpl();

    /**
     * {@inheritDoc}
     */
    @Override
    public List<LimitationEntity> getAll() {
        try {
            return limitationDAO.findAll();
        } catch (NullPointerException e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
            return new ArrayList<>();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LimitationEntity getByName(String name) {
        try {
            return limitationDAO.findByName(name);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
            LimitationEntity limitationEntity = new LimitationEntity();
            limitationEntity.setName("Geen beperking gevonden met deze naam");
            return limitationEntity;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addLimitation(LimitationEntity limitationEntity) {
        try {
            limitationDAO.add(limitationEntity);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateLimitation(LimitationEntity limitationEntity) {
        try {
            limitationDAO.update(limitationEntity);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
    }

    /**
     * {@inheritDoc}
     */
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
