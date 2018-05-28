package org.han.ica.oose.boterbloem.dao;

import org.han.ica.oose.boterbloem.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientDAO implements IClientDAO {
    private static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
    public static final IConnectionDAO CONNECTION_DAO = new ConnectionDAO();
    private double flatRate = 0.005;

    @Autowired
    public ClientDAO() {
        // empty constructor because of Spring
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void create(Client client) {
        try (PreparedStatement ps = CONNECTION_DAO.getPreparedStatement(
                "INSERT INTO Client VALUES(?, ?, ?, ?)")) {
            ps.setInt(1, client.getClientId());
            ps.setString(2, client.getCompanion());
            ps.setString(3, client.getUtility());
            ps.setBoolean(4, client.isDriverPreferenceF());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Problem with creating a client", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Client> getAllClients() {
        double priceToPay = 0;
        List<Client> foundCliënts = new ArrayList<>();
        try (
                PreparedStatement ps = CONNECTION_DAO.getPreparedStatement(
                        "SELECT\n" +
                                "C.clientId,\n" +
                                "CONCAT(U.firstname, ' ', U.lastname) AS name,\n" +
                                "C.PKB,\n" +
                                "C.warningPKB,\n" +
                                "(SELECT SUM(R.distance) FROM ride R WHERE R.clientId = C.clientId) AS totalMeters\n" +
                                "from User U INNER JOIN client C ON U.id = C.clientid"
                );
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String foundName = rs.getString("name");
                int PKB = rs.getInt("PKB");
                Boolean warningPKB = rs.getBoolean("warningPKB");
                int totalMeters = rs.getInt("totalMeters");
                int id = rs.getInt("clientId");
                    if (totalMeters > PKB){
                         priceToPay = (totalMeters - PKB) * flatRate;
                    }
                Client client = new Client(id,foundName, PKB, warningPKB,priceToPay,totalMeters);
                foundCliënts.add(client);
            }
            return foundCliënts;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return foundCliënts;
    }

    /**
     * {@inheritDoc}
     */
    public Client getClientById(int id) {
        double priceToPay = 0;
        Client client = null;
        try (
                PreparedStatement ps = CONNECTION_DAO.getPreparedStatement(
                        "SELECT\n" +
                                "C.clientId,\n" +
                                "CONCAT(U.firstname, ' ', U.lastname) AS name,\n" +
                                "C.PKB,\n" +
                                "C.warningPKB,\n" +
                                "(SELECT SUM(R.distance) FROM ride R WHERE R.clientId = C.clientId) AS totalMeters\n" +
                                "from User U INNER JOIN client C ON U.id = C.clientid \n" +
                                "WHERE C.clientid = " + id
                );
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String foundName = rs.getString("name");
                int PKB = rs.getInt("PKB");
                Boolean warningPKB = rs.getBoolean("warningPKB");
                int total_meters = rs.getInt("totalMeters");
                int idFound = rs.getInt("clientId");
                if (total_meters > PKB){
                    priceToPay = (total_meters - PKB) * flatRate;
                }
                client = new Client(idFound,foundName, PKB, warningPKB,priceToPay,total_meters);
            }
            return client;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return client;
    }
}