package org.han.ica.oose.boterbloem.domain.domainmappers;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IUtilityDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.UtilityDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.UtilityEntity;
import org.han.ica.oose.boterbloem.domain.domainobjects.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UtilityMapper {
    private static final Logger LOGGER = Logger.getLogger(UtilityMapper.class.getName());

    private IUtilityDAO utilityDAO = new UtilityDAOImpl();

    /**
     * GET all Utilities
     * @return list of Utilities
     */
    public List<Utility> getAllUtilities() {
        List<Utility> utilities = new ArrayList<>();
        try {
            for (UtilityEntity u : utilityDAO.findAll()) {
                Utility utility = fillUtilityDomain(u);
                utilities.add(utility);
            }
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.toString(), e);
        }
        return utilities;
    }

    /**
     *
     * @param u - The utilityEntity that will be filled
     * @return - A filled UtilityEntity
     */
    private Utility fillUtilityDomain(UtilityEntity u) {
        Utility utility = new Utility();
        utility.setUtility(u.getName());
        return utility;
    }
}
