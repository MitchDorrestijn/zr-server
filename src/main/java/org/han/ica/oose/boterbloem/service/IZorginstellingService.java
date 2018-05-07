package org.han.ica.oose.boterbloem.service;

import org.han.ica.oose.boterbloem.domain.Zorginstelling;

public interface IZorginstellingService {

    boolean checkIfExists(Zorginstelling zorginstelling);


    void saveZorginstelling(Zorginstelling zorginstelling);
}
