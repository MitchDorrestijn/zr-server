package org.han.ica.oose.boterbloem.service.serviceimplementation;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.*;
import org.han.ica.oose.boterbloem.dataaccess.entities.*;

import org.han.ica.oose.boterbloem.service.IDriverService;
import org.han.ica.oose.boterbloem.display.displayobject.CreateDriverDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.DriverDetailDisplay;
import org.han.ica.oose.boterbloem.display.displayobject.DriverDisplay;

import java.util.*;
import java.util.logging.*;

public class DriverService implements IDriverService {
    private static final Logger LOGGER = Logger.getLogger(DriverService.class.getName());

    private IDriverDAO driverDao = new DriverDAOImpl();
    private IRideDAO rideDAO = new RideDAOImpl();
    private IDrivercarDAO drivercarDAO = new DrivercarDAOImpl();
    private IRatingsDAO ratingsDAO = new RatingsDAOImpl();
    private IDrivercareinstitutionDAO drivercareinstitutionDAO = new DrivercareinstitutionDAOImpl();
    private IDriverlimitationmanageableDAO driverlimitationmanageableDAO = new DriverlimitationmanageableDAOImpl();

    public DriverService() {
        //Empty constructor
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DriverEntity findById(int id) {
        return driverDao.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List <DrivercarEntity> getAllDrivers() {
        return drivercarDAO.findAll();
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public List <DriverDisplay> allDriversWithStatistics() {
        try {
            List <DriverDisplay> returnList = new ArrayList <>();
            for (DriverEntity x : driverDao.findAll()) {
                int driverId = x.getDriverId();
                if (drivercareinstitutionDAO.getCareInstitutionId(driverId).isActive()) {
                    System.out.println(drivercareinstitutionDAO.getCareInstitutionId(x.getDriverId()).isActive());
                    DriverDisplay driver = new DriverDisplay();


                    System.out.println(driverId);

                    driver.setId(driverId);
                    driver.setName(x.getUserEntity().getFirstName() + " " + x.getUserEntity().getLastName());
                    driver.setTypeOfPayment(x.getTypeOfPayment());

                    try {
                        if (drivercarDAO.findCarById(driverId) == null) {
                            driver.setNumberOfPassengers(0);
                            driver.setNumberPlate("");
                        } else {
                            driver.setNumberOfPassengers(drivercarDAO.findCarById(driverId).getNumberOfPassengers());
                            driver.setNumberPlate(drivercarDAO.findCarById(driverId).getNumberPlate());
                        }
                    } catch ( Exception e ) {
                        System.out.println("Nieuwe exception: " + e.getMessage());
                    }

                    driver.setRating(ratingsDAO.getAvgRatings(driverId));
                    driver.setSegment("A");
                    driver.setTotalEarned(rideDAO.totalEarned(driverId));
                    driver.setTotalRides(rideDAO.rideCountById(driverId));

                    returnList.add(driver);
                }
            }
            return returnList;
        } catch ( Exception e ) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
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
        } catch ( Exception e ) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * {@inheritDoc}
     */
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
            } catch ( Exception e ) {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteDriverById(int id, int idCare) {
        DrivercareinstitutionEntityPK drivercareinstitutionEntityPK = new DrivercareinstitutionEntityPK();
        drivercareinstitutionEntityPK.setCareInstitutionId(idCare);
        drivercareinstitutionEntityPK.setDriverId(id);
        DrivercareinstitutionEntity drivercareinstitutionEntity = drivercareinstitutionDAO.find(drivercareinstitutionEntityPK);
        drivercareinstitutionEntity.setActive(false);
        drivercareinstitutionDAO.update(drivercareinstitutionEntity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCareInstitutionId(int id) {
        return (drivercareinstitutionDAO.getCareInstitutionId(id).getCareInstitutionId());
    }

    public CreateDriverDisplay getThisThing() {
        CreateDriverDisplay createDriverDisplay = new CreateDriverDisplay();
        createDriverDisplay.setDrivercarEntity(drivercarDAO.findCarById(1));
        createDriverDisplay.setDriver(driverDao.findById(1));
        createDriverDisplay.setCareInstitutionId(1);
        ArrayList <String> asd = new ArrayList <>();
        asd.add("Limitation");
        asd.add("something else");

        createDriverDisplay.setLimitationEntities(asd);
        return createDriverDisplay;
    }

}