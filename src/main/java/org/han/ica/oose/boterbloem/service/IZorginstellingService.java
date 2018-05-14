package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.domain.Zorginstelling;

import java.sql.SQLException;

public interface IZorginstellingService {

    Zorginstelling findById(int id) throws SQLException;

    void updateZorginstelling(Zorginstelling zorginstelling) throws SQLException;


    void saveZorginstelling(Zorginstelling zorginstelling);

    void deleteZorginstellingById(int zorginstelling);
}
