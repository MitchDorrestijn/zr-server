package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.dao.ZorginstellingDAO;
import org.han.ica.oose.boterbloem.domain.Zorginstelling;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class ZorginstellingService implements IZorginstellingService{

    ZorginstellingDAO DAO;

    /**
     * Finds and returns a Zorginstelling using the given ID
     * @param id ID of the zorginstelling
     * @return The zorginstelling that was found using the ID
     * @throws SQLException
     */
    @Override
    public Zorginstelling findById(int id) throws SQLException {
        System.out.println("service layer bereikt");
//        System.out.println(DAO.getByID(id));
        return (DAO.getByID(id));
    }

    /**
     *
     * @param zorginstelling Zorgstelling that needs a update
     * @throws SQLException
     */
    @Override
    public void updateZorginstelling(Zorginstelling zorginstelling) throws SQLException {
        DAO.updateZorginstellingWithId(zorginstelling.getId(), zorginstelling.getName()); // hij moet de geposte naam hier zetten
    }

    @Override
    public boolean checkIfExists(Zorginstelling zorginstelling) {
    List<Zorginstelling> instellingen = DAO.getAllZorginstellingen();
    for (Zorginstelling stellingen : instellingen){
        if (Objects.equals(stellingen.getName(), zorginstelling.getName())) {
            return false;
        }
    }
    return true;
    }

    @Override
    public void saveZorginstelling(Zorginstelling zorginstelling) {
        if (checkIfExists(zorginstelling)){
            DAO.create(zorginstelling);
        }
    }
}