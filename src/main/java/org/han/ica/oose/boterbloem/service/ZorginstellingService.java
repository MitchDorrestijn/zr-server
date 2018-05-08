package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.dao.ZorginstellingDAO;
import org.han.ica.oose.boterbloem.domain.Zorginstelling;

import java.sql.SQLException;

public class ZorginstellingService {

    /**
     * Finds and returns a Zorginstelling using the given ID
     * @param id ID of the zorginstelling
     * @return The zorginstelling that was found using the ID
     * @throws SQLException
     */
    public Zorginstelling findById(int id) throws SQLException {
        ZorginstellingDAO DAO = new ZorginstellingDAO();
        return (DAO.getByID(id));
    }

    /**
     *
     * @param zorginstelling Zorgstelling that needs a update
     * @throws SQLException
     */
    public void updateZorginstelling(Zorginstelling zorginstelling) throws SQLException {
        ZorginstellingDAO DAO = new ZorginstellingDAO();
        DAO.updateZorginstellingWithId(zorginstelling.getId(), zorginstelling.getName()); // hij moet de geposte naam hier zetten
    }
}