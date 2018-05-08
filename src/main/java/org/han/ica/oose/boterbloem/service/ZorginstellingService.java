package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.dao.ZorginstellingDAO;
import org.han.ica.oose.boterbloem.domain.Zorginstelling;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class ZorginstellingService {
    ZorginstellingDAO DAO = new ZorginstellingDAO();


    public ZorginstellingService(){
        // Empty constructor
    }
    /**
     * Finds and returns a Zorginstelling using the given ID
     *
     * @param id ID of the zorginstelling
     * @return The zorginstelling that was found using the ID
     * @throws SQLException
     */
    public Zorginstelling findById(int id) {
        ZorginstellingDAO dao = new ZorginstellingDAO();
        return (dao.getByID(id));
    }

    /**
     * @param zorginstelling Zorgstelling that needs a update
     * @throws SQLException
     */
    public void updateZorginstelling(Zorginstelling zorginstelling)  {
        ZorginstellingDAO dao = new ZorginstellingDAO();
        dao.updateZorginstellingWithId(zorginstelling.getId(), zorginstelling.getName()); // hij moet de geposte naam hier zetten
    }

    /**
     *
     * @param zorginstelling thats going to be added to the database
     */
    public void saveZorginstelling(Zorginstelling zorginstelling) {
        DAO.create(zorginstelling);
    }
    /**
     *
     * @return List of all zorginstellingen
     */
    public List<Zorginstelling> getAllZorginstellingen() {
        ZorginstellingDAO dao = new ZorginstellingDAO();
        return dao.getAllZorginstellingen();
    }
}