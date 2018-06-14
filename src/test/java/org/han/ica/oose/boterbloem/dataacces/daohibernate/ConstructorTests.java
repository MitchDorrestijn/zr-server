package org.han.ica.oose.boterbloem.dataacces.daohibernate;

import org.han.ica.oose.boterbloem.dataaccess.daohibernate.*;
import org.han.ica.oose.boterbloem.dataaccess.daohibernate.daoimplementation.*;
import org.han.ica.oose.boterbloem.utils.exceptions.JwtTokenIsIncorrectException;
import org.han.ica.oose.boterbloem.utils.exceptions.JwtTokenNotFoundException;
import org.han.ica.oose.boterbloem.utils.exceptions.UserNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WithMockUser(username = "Alex", password = "Qwerty123", roles = {"ADMIN", "CAREINSTITUTION"})
public class ConstructorTests {



    @Test
    public void testConstructors() {

    CareinstitutionDAOImpl careinstitutionDAO = new CareinstitutionDAOImpl();
    ClientcareinstitutionDAOImpl clientcareinstitutionDAO = new ClientcareinstitutionDAOImpl();
    ClientDAOImpl clientDAO = new ClientDAOImpl();
    ClientdriverpreferenceDAOImpl clientdriverpreferenceDAO = new ClientdriverpreferenceDAOImpl();
    IClientlimitationDAO clientlimitationDAO = new ClientlimitationDAOImpl();
    IClientUtilityDAO clientUtilityDAO = new ClientUtilityDAO();
        IDriveravailabilityDAO driveravailabilityDAO =  new DriveravailabilityDAOImpl();
        IDrivercarDAO drivercarDAO =  new DrivercarDAOImpl();
        IDrivercareinstitutionDAO drivercareinstitutionDAO = new DrivercareinstitutionDAOImpl();
        IDriverclientpreferenceDAO driverclientpreferenceDAO = new DriverclientpreferenceDAOImpl();
        ILimitationDAO  limitationDAO =  new LimitationDAOImpl();
        IRidecanceledbydriverDAO ridecanceledbydriverDAO =  new RidecanceledbydriverDAOImpl();
        IRidematchescacheDAO ridematchescacheDAO =  new RidematchescacheDAOImpl();
        IRidematchesrejectedDAO ridematchesrejectedDAO = new RidematchesrejectedDAOImpl();
        IRidematchesstateDAO ridematchesstateDAO =  new RidematchesstateDAOImpl();
        IUtilityDAO utilityDAO =  new UtilityDAOImpl();
        IRideproposedfordriverDAO rideproposedfordriverDAO =  new RideproposedfordriverDAOImpl();
        try{
            System.out.println("Test");
        }catch (JwtTokenIsIncorrectException e){
            System.out.println("e");
        }
        try{
            System.out.println("Test");
        }catch (JwtTokenNotFoundException e){
            System.out.println("e");
        }
        try{
            System.out.println("Test");
        }catch (UserNotFoundException e){
            System.out.println("e");
        }




    }


}
