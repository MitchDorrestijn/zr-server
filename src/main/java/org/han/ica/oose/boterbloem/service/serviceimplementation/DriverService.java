package org.han.ica.oose.boterbloem.service.serviceimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.*;
import org.han.ica.oose.boterbloem.dataaccess.entities.DriverlimitationmanageableEntity;

import org.han.ica.oose.boterbloem.domain.domainmappers.DriverMapper;
import org.han.ica.oose.boterbloem.display.displayobject.CreateDriverDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.DriverDetailDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.DriverDisplay;

import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercarEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercareinstitutionEntity;
import org.han.ica.oose.boterbloem.dataaccess.entities.DrivercareinstitutionEntityPK;
import org.han.ica.oose.boterbloem.service.IDriverService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverService implements IDriverService {
    private static final Logger LOGGER = Logger.getLogger(DriverService.class.getName());


    private IDriverDAO driverDao = new DriverDAOImpl();
    private IRideDAO rideDAO = new RideDAOImpl();
    private IDrivercarDAO drivercarDAO = new DrivercarDAOImpl();
    private IRatingsDAO ratingsDAO = new RatingsDAOImpl();
    private IUserDAO userDAO = new UserDAOImpl();
    private IDrivercareinstitutionDAO drivercareinstitutionDAO = new DrivercareinstitutionDAOImpl();
    private IDriverlimitationmanageableDAO driverlimitationmanageableDAO = new DriverlimitationmanageableDAOImpl();
    private DriverMapper driverMapper = new DriverMapper();


    public DriverService() {
        //Empty constructor
    }

    /***
     * @return A list of all chauffeurs and their properties
     */
    @Override
    public List<DrivercarEntity> getAllDrivers() {
        return drivercarDAO.findAll();
    }

    /**
     * @param id id of the careInstitution
     * @return A list of drivers from a specifec care institution
     */
    @Override
    public List<DriverDisplay> getAllDriversFromASpecificCareInstitution(int id) {
        return driverMapper.getAllDriversFromASpecificCareInstitution(id);
    }

    /**
     * @return a list of all drivers from all care institutions
     */
    @Override
    public List<DriverDisplay> allDriversWithStatistics() {
        return driverMapper.allDriversWithStatistics();
    }

    public DriverDetailDisplay getDriverDetails(int id) {
        DriverDetailDisplay driverDetailDisplay = new DriverDetailDisplay();
        try {
            driverDetailDisplay.setDriver(driverDao.findById(id));
            driverDetailDisplay.setDrivercarEntity(drivercarDAO.findCarById(id));
            driverDetailDisplay.setLimitationEntities(driverlimitationmanageableDAO.getByDriverId(id));
            driverDetailDisplay.setCareInstitutionId(drivercareinstitutionDAO.getDriverCareinstitutionId(id));


        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }

        return driverDetailDisplay;
    }

    public void createChauffeur(CreateDriverDisplay createDriverDisplay) {
        try {
            driverDao.add(createDriverDisplay.getDriver());

            DrivercarEntity drivercarEntity = createDriverDisplay.getDrivercarEntity();
            drivercarEntity.setDriverId(driverDao.latestId());
            DrivercareinstitutionEntity drivercareinstitutionEntity = new DrivercareinstitutionEntity();
            drivercareinstitutionEntity.setDriverId(driverDao.latestId());
            drivercareinstitutionEntity.setCareInstitutionId(createDriverDisplay.getCareInstitutionId());
            drivercareinstitutionEntity.setActive(true);
            drivercareinstitutionDAO.add(drivercareinstitutionEntity);
            drivercarDAO.add(createDriverDisplay.getDrivercarEntity());
            for (String lm : createDriverDisplay.getLimitationEntities()) {
                DriverlimitationmanageableEntity driverlimitationmanageableEntity = new DriverlimitationmanageableEntity();
                driverlimitationmanageableEntity.setDriverId(driverDao.latestId());
                driverlimitationmanageableEntity.setLimitation(lm);
                driverlimitationmanageableDAO.add(driverlimitationmanageableEntity);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public CreateDriverDisplay getThisThing() {
        CreateDriverDisplay createDriverDisplay = new CreateDriverDisplay();
        createDriverDisplay.setDrivercarEntity(drivercarDAO.findCarById(1));
        createDriverDisplay.setDriver(driverDao.findById(1));
        createDriverDisplay.setCareInstitutionId(1);
        ArrayList<String> asd = new ArrayList<>();
        asd.add("Limitation");
        asd.add("something else");

        createDriverDisplay.setLimitationEntities(asd);
        return createDriverDisplay;
    }

    @Override
    public void deleteDriver(int id, int idcare) {
        DrivercareinstitutionEntityPK drivercareinstitutionEntityPK = new DrivercareinstitutionEntityPK();
        drivercareinstitutionEntityPK.setCareInstitutionId(idcare);
        drivercareinstitutionEntityPK.setDriverId(id);
        DrivercareinstitutionEntity drivercareinstitutionEntity = drivercareinstitutionDAO.find(drivercareinstitutionEntityPK);
        drivercareinstitutionEntity.setActive(false);
        drivercareinstitutionDAO.update(drivercareinstitutionEntity);
    }

    @Override
    public int getCareInstitutionId(int id) {
        return (drivercareinstitutionDAO.getCareInstitutionId(id).getCareInstitutionId());
    }

    @Override
    public void updateDriver(CreateDriverDisplay createDriverDisplay) {
        int driverId = createDriverDisplay.getDriver().getDriverId();
        if (createDriverDisplay.getDriver() != driverDao.findById(driverId)) {
            driverDao.update(createDriverDisplay.getDriver());
        }
        if (createDriverDisplay.getDrivercarEntity() != drivercarDAO.findCarById(driverId)) {
            try {
                drivercarDAO.remove(drivercarDAO.findCarById(driverId));
                drivercarDAO.update(createDriverDisplay.getDrivercarEntity());
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, e.getMessage());
            }
        }
        if (createDriverDisplay.getCareInstitutionId() != drivercareinstitutionDAO.getDriverCareinstitutionId(driverId)) {
            drivercareinstitutionDAO.updateCareInstituion(createDriverDisplay.getCareInstitutionId(), driverId);
        }
        if (createDriverDisplay.getLimitationEntities() != driverlimitationmanageableDAO.getByDriverId(driverId)) {
            driverlimitationmanageableDAO.updateDriverLimitations(createDriverDisplay.getLimitationEntities(), driverId);
        }
    }


}