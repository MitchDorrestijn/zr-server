package org.han.ica.oose.boterbloem.dao;

import org.han.ica.oose.boterbloem.domain.Chauffeur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class for handling the CRUD operations on Chauffeur
 */
public class ChauffeurDAO implements IChauffeurDAO {
    private static final Logger LOGGER = Logger.getLogger(ZorginstellingDAO.class.getName());
    public static final IConnectionDAO CONNECTION_DAO = new ConnectionDAO();

    public ChauffeurDAO() {
        //Empty constructor for SpringBoot
    }

    /***
     * @return All chauffeurs and their properties fetched from the database
     */
    @Override
    public List<Chauffeur> getAllChauffeurs() {
        List<Chauffeur> chauffeurs = new ArrayList<>();
        try (
                PreparedStatement ps = CONNECTION_DAO.getPreparedStatement(
                        "SELECT \n" +
                                "user.id,\n" +
                                "CONCAT(user.firstname, ' ', user.lastname) AS name, \n" +
                                "driver.type_of_payment,\n" +
                                "(SELECT COALESCE(ROUND(SUM(ride.price_of_ride), 2), 0) FROM ride WHERE driver.driverId = ride.driverId) AS total_earned,\n" +
                                "(SELECT COUNT(*) FROM ride WHERE driver.driverId = ride.driverId) AS total_rides,\n" +
                                "(SELECT numberPlate FROM driverCar WHERE driverCar.driverId = driver.driverId) AS numberplate,\n" +
                                "(SELECT numberOfPassengers FROM driverCar WHERE driverCar.driverId = driver.driverId) AS number_of_passengers,\n" +
                                "(SELECT utility FROM driverCar WHERE driverCar.driverId = driver.driverId) AS segment,\n" +
                                "(SELECT ROUND(AVG(sterren), 0) FROM beoordelingen WHERE beoordelingen.driverId = driver.driverId) AS rating\n" +
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

                Chauffeur chauffeur = new Chauffeur(id,name, typeOfPayment, totalEarned, totalRides, numberPlate,
                        numberOfPassengers, segment, rating);
                chauffeurs.add(chauffeur);
            }
            return chauffeurs;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);

        }
        return chauffeurs;
    }
}
