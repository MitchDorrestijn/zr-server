package org.han.ica.oose.boterbloem.service;

import com.sun.istack.internal.logging.Logger;
import org.han.ica.oose.boterbloem.dao.ZorginstellingDAO;
import org.han.ica.oose.boterbloem.domain.Zorginstelling;

import java.util.List;
import java.util.Objects;


public class ZorginstellingService implements IZorginstellingService{

    private ZorginstellingDAO DAO;

    @Override
    public boolean checkIfExists(Zorginstelling zorginstelling) {
        List<Zorginstelling> allInstellingen = DAO.getByName(zorginstelling.getName());
        for (Zorginstelling instellingen : allInstellingen) {
            if (Objects.equals(zorginstelling.getName(), instellingen.getName())) {
                return true;
            }
        }
        return false;
    }


    @Override
    public void saveZorginstelling(Zorginstelling zorginstelling) {
        if (checkIfExists(zorginstelling)){
            DAO.create(zorginstelling);
        }
    }
}
