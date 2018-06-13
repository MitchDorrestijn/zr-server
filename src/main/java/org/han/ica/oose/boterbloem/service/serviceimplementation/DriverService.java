package org.han.ica.oose.boterbloem.service.serviceimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.*;
import org.han.ica.oose.boterbloem.dataaccess.entities.*;
import org.han.ica.oose.boterbloem.display.displayobject.CreateDriverDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.DriverDetailDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.DriverDisplay;
import org.han.ica.oose.boterbloem.domain.domainmappers.DriverMapper;
import org.han.ica.oose.boterbloem.service.IDriverService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;


public class DriverService implements IDriverService {
    private static final Logger LOGGER = Logger.getLogger(DriverService.class.getName());

    private IDriverDAO driverDao = new DriverDAOImpl();
    private IDrivercarDAO drivercarDAO = new DrivercarDAOImpl();
    private IDrivercareinstitutionDAO drivercareinstitutionDAO = new DrivercareinstitutionDAOImpl();
    private IDriverlimitationmanageableDAO driverlimitationmanageableDAO = new DriverlimitationmanageableDAOImpl();
    private DriverMapper driverMapper = new DriverMapper();
    private IUserDAO userDAO = new UserDAOImpl();


    public DriverService() {
        //Empty constructor
    }

    @Override
    public DriverEntity findById(int id) {
        return driverDao.findById(id);
    }

    @Override
    public List <DrivercarEntity> getAllDrivers() {
        return drivercarDAO.findAll();
    }

    @Override
    public DriverDetailDisplay getDriverDetails(int id) {
        DriverDetailDisplay driverDetailDisplay = new DriverDetailDisplay();
        try {
            driverDetailDisplay.setDriver(driverDao.findById(id));
            driverDetailDisplay.setDrivercarEntity(drivercarDAO.findCarById(id));
            driverDetailDisplay.setLimitationEntities(driverlimitationmanageableDAO.getByDriverId(id));
            driverDetailDisplay.setCareInstitutionId(drivercareinstitutionDAO.getDriverCareinstitutionId(id));
        } catch ( Exception e ) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return driverDetailDisplay;
    }

    @Override
    public List <DriverDisplay> allDriversWithStatistics() {
        return driverMapper.allDriversWithStatistics();
    }

    @Override
    public void createChauffeur(CreateDriverDisplay createDriverDisplay) {
        try {
            driverDao.add(createDriverDisplay.getDriver());
            DrivercareinstitutionEntity drivercareinstitutionEntity = new DrivercareinstitutionEntity();
            drivercareinstitutionEntity.setDriverId(driverDao.latestId());
            drivercareinstitutionEntity.setCareInstitutionId(createDriverDisplay.getCareInstitutionId());
            drivercareinstitutionEntity.setActive(true);
            drivercareinstitutionDAO.add(drivercareinstitutionEntity);
            drivercarDAO.add(createDriverDisplay.getDrivercar());
            for (String lm : createDriverDisplay.getLimitations()) {
                DriverlimitationmanageableEntity driverlimitationmanageableEntity = new DriverlimitationmanageableEntity();
                driverlimitationmanageableEntity.setDriverId(driverDao.latestId());
                driverlimitationmanageableEntity.setLimitation(lm);
                driverlimitationmanageableDAO.add(driverlimitationmanageableEntity);
            }
        } catch ( Exception e ) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }
    }

    @Override
    public void updateDriver(CreateDriverDisplay createDriverDisplay) {
        int driverId = createDriverDisplay.getDriver().getDriverId();
            driverDao.update(createDriverDisplay.getDriver());
        if (!createDriverDisplay.getDrivercar().equals(drivercarDAO.findCarById(driverId))) {
            try {
                drivercarDAO.remove(drivercarDAO.findCarById(driverId));
                drivercarDAO.update(createDriverDisplay.getDrivercar());
            } catch ( Exception e ) {
                LOGGER.log(Level.WARNING, e.getMessage());
            }
        }
        if (createDriverDisplay.getCareInstitutionId() != drivercareinstitutionDAO.getDriverCareinstitutionId(driverId)) {
            drivercareinstitutionDAO.updateCareInstituion(createDriverDisplay.getCareInstitutionId(), driverId);
        }
        if (!createDriverDisplay.getLimitations().equals(driverlimitationmanageableDAO.getByDriverId(driverId))) {
            driverlimitationmanageableDAO.updateDriverLimitations(createDriverDisplay.getLimitations(), driverId);
        }
    }

    @Override
    public void deleteDriverById(int id, int idCare) {
        DrivercareinstitutionEntityPK drivercareinstitutionEntityPK = new DrivercareinstitutionEntityPK();
        drivercareinstitutionEntityPK.setCareInstitutionId(idCare);
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
    public List <DriverDisplay> getAllDriversFromASpecificCareInstitution(int id) {
        return driverMapper.getAllDriversFromASpecificCareInstitution(id);
    }

    public CreateDriverDisplay getThisThing() {
        CreateDriverDisplay createDriverDisplay = new CreateDriverDisplay();
        createDriverDisplay.setDrivercar(drivercarDAO.findCarById(1));
        createDriverDisplay.setDriver(driverDao.findById(1));
        createDriverDisplay.setCareInstitutionId(1);
        ArrayList<String> asd = new ArrayList<>();
        asd.add("Limitation");
        asd.add("something else");

        createDriverDisplay.setLimitations(asd);
        return createDriverDisplay;
    }

    /**
     * Setter for property 'driverDao'.
     *
     * @param driverDao Value to set for property 'driverDao'.
     */
    public void setDriverDao(IDriverDAO driverDao) {
        this.driverDao = driverDao;
    }

    /**
     * Setter for property 'drivercarDAO'.
     *
     * @param drivercarDAO Value to set for property 'drivercarDAO'.
     */
    public void setDrivercarDAO(IDrivercarDAO drivercarDAO) {
        this.drivercarDAO = drivercarDAO;
    }

    /**
     * Setter for property 'drivercareinstitutionDAO'.
     *
     * @param drivercareinstitutionDAO Value to set for property 'drivercareinstitutionDAO'.
     */
    public void setDrivercareinstitutionDAO(IDrivercareinstitutionDAO drivercareinstitutionDAO) {
        this.drivercareinstitutionDAO = drivercareinstitutionDAO;
    }

    /**
     * Setter for property 'driverlimitationmanageableDAO'.
     *
     * @param driverlimitationmanageableDAO Value to set for property 'driverlimitationmanageableDAO'.
     */
    public void setDriverlimitationmanageableDAO(IDriverlimitationmanageableDAO driverlimitationmanageableDAO) {
        this.driverlimitationmanageableDAO = driverlimitationmanageableDAO;
    }

    /**
     * Setter for property 'driverMapper'.
     *
     * @param driverMapper Value to set for property 'driverMapper'.
     */
    public void setDriverMapper(DriverMapper driverMapper) {
        this.driverMapper = driverMapper;
    }

    /**
     * Setter for property 'userDAO'.
     *
     * @param userDAO Value to set for property 'userDAO'.
     */
    public void setUserDAO(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }
}