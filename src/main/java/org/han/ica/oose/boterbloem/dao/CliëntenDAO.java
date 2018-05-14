package org.han.ica.oose.boterbloem.dao;

import org.han.ica.oose.boterbloem.domain.Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CliëntenDAO implements ICliëntenDAO {
    private static final Logger LOGGER = Logger.getLogger(ZorginstellingDAO.class.getName());
    public static final DAO dao = new DAO();

   public CliëntenDAO(){
       // empty constructor for spring
   }

   /*
     @Override
    public List<Zorginstelling> getAllZorginstellingen() {
        List<Zorginstelling> zorginstellingen = new ArrayList<>();
        try (PreparedStatement ps = dao.getPreparedStatement("SELECT * FROM careInstitution");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String foundName = rs.getString("name");
                int foundId = rs.getInt("id");
                Zorginstelling zorginstelling = new Zorginstelling(foundId, foundName);
                zorginstellingen.add(zorginstelling);
            }
            return zorginstellingen;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return zorginstellingen;
    }

    */
    @Override
    public List<Client> getAllCliënts() throws SQLException {
        List<Client> foundCliënts = new ArrayList<>();
        try (
                PreparedStatement ps = dao.getPreparedStatement(
                        "select \n" +
                                "CONCAT(U.firstname, ' ', U.lastname) AS name,\n" +
                                "C.PKB,\n" +
                                "(SELECT SUM(R.distance) FROM ride R WHERE R.clientId = C.clientId) AS Total_Meters\n" +
                                "from User U INNER JOIN client C ON U.id = C.clientid\n"
                );
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String foundName = rs.getString("name");
                int PKB = rs.getInt("PKB");
                int total_meters = rs.getInt("Total_Meters");

                Client client = new Client(PKB, foundName, total_meters);
                foundCliënts.add(client);
            }
            return foundCliënts;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return foundCliënts;
    }
}

