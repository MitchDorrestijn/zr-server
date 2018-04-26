package org.han.ica.oose.boterbloem;

import org.han.ica.oose.boterbloem.database.DatabaseTestQuery;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

// Moet dit een test voorstellen?
public class DBtestRunner {
    public static void main(String[] args) throws SQLException {
        DatabaseTestQuery databaseTestQuery = new DatabaseTestQuery();
        databaseTestQuery.getCompanion();
    }
}
