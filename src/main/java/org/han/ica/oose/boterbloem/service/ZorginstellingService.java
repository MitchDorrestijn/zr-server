package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.dao.ZorginstellingDAO;
import org.han.ica.oose.boterbloem.domain.Zorginstelling;

import java.util.List;

public class ZorginstellingService implements IZorginstellingService{
    ZorginstellingDAO zorginstellingDAO = new ZorginstellingDAO();

    public ZorginstellingService() {
        // Empty constructor
    }

    /**
     * Finds and returns a Zorginstelling using the given ID
     *
     * @param id ID of the zorginstelling
     * @return The zorginstelling that was found using the ID
     */
    public Zorginstelling findById(int id) {
        ZorginstellingDAO dao = new ZorginstellingDAO();
        return (dao.getByID(id));
    }

    /**
     * @param zorginstelling Zorgstelling that needs a update
     */
    public void updateZorginstelling(Zorginstelling zorginstelling) {
        ZorginstellingDAO dao = new ZorginstellingDAO();
        dao.updateZorginstelling(zorginstelling.getId(), zorginstelling.getName()); // hij moet de geposte naam hier zetten
    }

    @Override
    public boolean checkIfExists(Zorginstelling zorginstelling) {
        return false;
    }

    /**
     * @param zorginstelling that's going to be added to the database
     */
    public void saveZorginstelling(Zorginstelling zorginstelling) {
        zorginstellingDAO.create(zorginstelling);
    }

    /**
     * @return List of all zorginstellingen
     */
    public List <Zorginstelling> getAllZorginstellingen() {
        ZorginstellingDAO dao = new ZorginstellingDAO();
        return dao.getAllZorginstellingen();
    }

    /**
     * @param zorginstellingID Zorginstelling
     */
    public void deleteZorginstellingById(int zorginstellingID) {
        ZorginstellingDAO dao = new ZorginstellingDAO();
        dao.deleteById(zorginstellingID);
    }
}
