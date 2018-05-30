package org.han.ica.oose.boterbloem.mapper;

import org.han.ica.oose.boterbloem.daoHibernate.DriverDAOImpl;
import org.han.ica.oose.boterbloem.daoHibernate.IDriverDAO;
import org.han.ica.oose.boterbloem.service.RatingsService;
import org.han.ica.oose.boterbloem.service.displays.DriverDisplay;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DriverMapper {
    private static final Logger LOGGER = Logger.getLogger(RatingsService.class.getName());

    private IDriverDAO driverDAO = new DriverDAOImpl();

    public List<DriverDisplay> getAllDriversFromASpecificCareInstitution(int id){
        List<DriverDisplay> returnList = new ArrayList<>();
        return returnList;
    }


}
