package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.daoHibernate.*;

import org.han.ica.oose.boterbloem.entity.*;
import org.han.ica.oose.boterbloem.service.projection.CreateDriverDisplay;
import org.han.ica.oose.boterbloem.service.projection.DriverDetailDisplay;
import org.han.ica.oose.boterbloem.service.projection.DriverDisplay;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class DriverService implements IDriverService {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("zorgrit");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    private IDriverDAO driverDao = new DriverDAOImpl(entityManager);
    private IRideDAO rideDAO = new RideDAOImpl(entityManager);
    private IDrivercarDAO drivercarDAO = new DrivercarDAOImpl(entityManager);
    private IRatingsDAO ratingsDAO = new RatingsDAOImpl(entityManager);
    private IUserDAO userDAO = new UserDAOImpl(entityManager);
    private IDrivercareinstitutionDAO drivercareinstitutionDAO = new DrivercareinstitutionDAOImpl(entityManager);
    private IDriverlimitationmanageableDAO driverlimitationmanageableDAO = new DriverlimitationmanageableDAOImpl(entityManager);


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

    public List<DriverDisplay> allDriversWithStatistics(){
        List<DriverDisplay> returnList =  new ArrayList<>();
        for (DriverEntity x: driverDao.findAll()) {

            DriverDisplay driver = new DriverDisplay();


            int driverId = x.getDriverId();
            System.out.println(driverId);

            driver.setId(driverId);
            driver.setName(x.getUserEntity().getFirstName() + " " + x.getUserEntity().getLastName());
            driver.setTypeOfPayment(x.getTypeOfPayment());

            if(drivercarDAO.findCarById(driverId) == null) {
                driver.setNumberOfPassengers(0);
                driver.setNumberPlate("");
            } else {
                driver.setNumberOfPassengers(drivercarDAO.findCarById(driverId).getNumberOfPassengers());
                driver.setNumberPlate(drivercarDAO.findCarById(driverId).getNumberPlate());
            }

            driver.setRating(ratingsDAO.getAvgRatings(driverId));
            driver.setSegment("A");
            driver.setTotalEarned(rideDAO.totalEarned(driverId));
            driver.setTotalRides(rideDAO.rideCountById(driverId));
            returnList.add(driver);
        }
        return returnList;
    }

    public DriverDetailDisplay getDriverDetails(int id){

return null;
    }

    public void createChauffeur(CreateDriverDisplay createDriverDisplay) {

        try{
            driverDao.add(createDriverDisplay.getDriver());

            DrivercarEntity drivercarEntity = createDriverDisplay.getDrivercarEntity();
            drivercarEntity.setDriverId(driverDao.latestId());
        DrivercareinstitutionEntity drivercareinstitutionEntity = new DrivercareinstitutionEntity();
        drivercareinstitutionEntity.setDriverId(driverDao.latestId());
        drivercareinstitutionEntity.setCareInstitutionId(createDriverDisplay.getCareInstitutionId());
        drivercareinstitutionDAO.add(drivercareinstitutionEntity);
        drivercarDAO.add(createDriverDisplay.getDrivercarEntity());
        for (String lm : createDriverDisplay.getLimitationEntities()) {
            DriverlimitationmanageableEntity driverlimitationmanageableEntity = new DriverlimitationmanageableEntity();
            driverlimitationmanageableEntity.setDriverId(driverDao.latestId());
            driverlimitationmanageableEntity.setLimitation(lm);
            driverlimitationmanageableDAO.add(driverlimitationmanageableEntity);
            System.out.println(entityManager.getTransaction().isActive());
        }
        } catch(Exception e){
            System.out.println(e.getMessage());

            }

        }

    public CreateDriverDisplay getThisThing(){
        CreateDriverDisplay createDriverDisplay = new CreateDriverDisplay();
        createDriverDisplay.setDrivercarEntity(drivercarDAO.findCarById(1));
        createDriverDisplay.setDriver(driverDao.findById(1));
        createDriverDisplay.setCareInstitutionId(1);
        ArrayList<String> asd = new ArrayList<>();
        asd.add("Limitation");
        asd.add("something else");

        createDriverDisplay.setLimitationEntities(asd);
        System.out.println(entityManager.getTransaction().isActive());
        return createDriverDisplay;
    }

}