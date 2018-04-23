package org.han.ica.oose.boterbloem.SQL;

import java.sql.SQLException;

public class DBtestRunner {
    public static void main(String[] args) throws SQLException {
        DatabaseTestQuery databaseTestQuery = new DatabaseTestQuery();
        databaseTestQuery.getCompanion();
    }
}
