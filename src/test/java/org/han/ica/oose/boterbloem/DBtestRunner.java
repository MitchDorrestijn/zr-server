package org.han.ica.oose.boterbloem;

import org.han.ica.oose.boterbloem.database.DatabaseTestQuery;

import java.sql.SQLException;

public class DBtestRunner {
    public static void main(String[] args) throws SQLException {
        DatabaseTestQuery databaseTestQuery = new DatabaseTestQuery();
        databaseTestQuery.getCompanion();
    }
}
