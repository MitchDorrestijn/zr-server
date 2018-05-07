package org.han.ica.oose.boterbloem;

import org.han.ica.oose.boterbloem.dao.ZorginstellingDAO;
import org.han.ica.oose.boterbloem.service.ZorginstellingService;

import java.sql.SQLException;

public class TestClass {
    public static void main(String[] args) {
         ZorginstellingDAO dao;
         ZorginstellingService service = new ZorginstellingService();
        try {
            service.findById(7);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
