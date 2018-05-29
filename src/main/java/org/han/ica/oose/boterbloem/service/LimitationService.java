package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.daoHibernate.ILimitationDAO;
import org.han.ica.oose.boterbloem.daoHibernate.LimitationDAOImpl;
import org.han.ica.oose.boterbloem.entity.LimitationEntity;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LimitationService implements ILimitationService {
    private static final Logger LOGGER = Logger.getLogger(LimitationService.class.getName());
    ILimitationDAO limitationDAO = new LimitationDAOImpl();

    @Override
    public List<LimitationEntity> getAll() {
        try{
            return limitationDAO.findAll();
        } catch (NullPointerException e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
            return null;
        }
    }
}
