package org.han.ica.oose.boterbloem.dao;

import org.han.ica.oose.boterbloem.domain.Driver;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class for handling the CRUD operations on Driver
 */
public class DriverDAO implements IDriverDAO {
    private static final Logger LOGGER = Logger.getLogger(CareInstitutionDAO.class.getName());
    public static final DAO dao = new DAO();

    public DriverDAO() {
        //Empty constructor for SpringBoot
    }

    /***
     * @return All drivers and their properties fetched from the database
     */
    @Override
    public List<Driver> getAllDrivers() {
        List<Driver> drivers = new ArrayList<>();
        try (
                PreparedStatement ps = dao.getPreparedStatement(
                        "SELECT \n" +
                                "user.id,\n" +
                                "CONCAT(user.firstname, ' ', user.lastname) AS name, \n" +
                                "driver.type_of_payment,\n" +
                                "(SELECT COALESCE(ROUND(SUM(ride.price_of_ride), 2), 0) FROM ride WHERE driver.driverId = ride.driverId) AS total_earned,\n" +
                                "(SELECT COUNT(*) FROM ride WHERE driver.driverId = ride.driverId) AS total_rides,\n" +
                                "(SELECT numberPlate FROM driverCar WHERE driverCar.driverId = driver.driverId) AS numberplate,\n" +
                                "(SELECT numberOfPassengers FROM driverCar WHERE driverCar.driverId = driver.driverId) AS number_of_passengers,\n" +
                                "(SELECT utility FROM driverCar WHERE driverCar.driverId = driver.driverId) AS segment,\n" +
                                "(SELECT ROUND(AVG(sterren), 0) FROM ratings WHERE ratings.driverId = driver.driverId) AS rating\n" +
                                "FROM user INNER JOIN driver ON driver.driverId = user.id \n" +
                                "WHERE (SELECT numberPlate FROM driverCar WHERE driverCar.driverId = driver.driverId) IS NOT NULL\n" +
                                "GROUP BY user.id, user.firstname, user.lastname, driver.type_of_payment"
                );
                ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String typeOfPayment = rs.getString("type_of_payment");
                Float totalEarned = rs.getFloat("total_earned");
                int totalRides = rs.getInt("total_rides");
                String numberPlate = rs.getString("numberplate");
                int numberOfPassengers = rs.getInt("number_of_passengers");
                String segment = rs.getString("segment");
                int rating = rs.getInt("rating");

                Driver driver = new Driver(id,name, typeOfPayment, totalEarned, totalRides, numberPlate,
                        numberOfPassengers, segment, rating);
                drivers.add(driver);
            }
            return drivers;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);

        }
        return drivers;
    }
}
