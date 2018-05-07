package org.han.ica.oose.boterbloem.Service;

import org.han.ica.oose.boterbloem.dao.ZorginstellingDAO;
import org.han.ica.oose.boterbloem.domain.Zorginstelling;

import java.sql.SQLException;

public class ZorginstellingService {


    public Zorginstelling findById(int id) throws SQLException {
        ZorginstellingDAO DAO = new ZorginstellingDAO();
        return (DAO.getByID(id));
    }

    public void updateZorginstelling(Zorginstelling zorginstelling) throws SQLException {
        ZorginstellingDAO DAO = new ZorginstellingDAO();
        DAO.updateZorginstellingWithId(zorginstelling.getId(), zorginstelling.getName()); // hij moet de geposte naam hier zetten
    }
}