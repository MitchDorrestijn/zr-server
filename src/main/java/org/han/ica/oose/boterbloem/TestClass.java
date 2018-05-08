package org.han.ica.oose.boterbloem;

import org.han.ica.oose.boterbloem.dao.ZorginstellingDAO;
import org.han.ica.oose.boterbloem.service.ZorginstellingService;
import org.han.ica.oose.boterbloem.domain.Zorginstelling;

import java.sql.SQLException;

public class TestClass {
    public static void main(String[] args) {
         ZorginstellingDAO dao;
         ZorginstellingService service = new ZorginstellingService();
        Zorginstelling test = new Zorginstelling(50, "mees zijn stelling");
        service.saveZorginstelling(test);
    }
}
