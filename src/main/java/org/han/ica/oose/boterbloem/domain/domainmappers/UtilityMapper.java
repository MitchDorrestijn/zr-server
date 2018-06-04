package org.han.ica.oose.boterbloem.domain.domainmappers;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.IUtilityDAO;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.UtilityDAOImpl;
import org.han.ica.oose.boterbloem.dataaccess.entities.UtilityEntity;
import org.han.ica.oose.boterbloem.domain.domainobjects.Utility;

public class UtilityMapper {
    IUtilityDAO utilityDAO = new UtilityDAOImpl();

    public Utility getUtility(String name) {
        UtilityEntity utilityEntity = utilityDAO.findByName(name);
        Utility utility = new Utility();
        utility.setUtility(utilityEntity.getName());
        return utility;
    }

    public UtilityEntity convertUtility(Utility utility) {
        UtilityEntity utilityEntity = new UtilityEntity();
        utilityEntity.setName(utility.getUtility());
        return utilityEntity;
    }
}
