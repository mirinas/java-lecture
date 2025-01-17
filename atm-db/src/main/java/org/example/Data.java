package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Data {

    public static void saveAccount(Account acc) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:data.db");

            conn.createStatement().execute(
                    "CREATE TABLE IF NOT EXISTS accounts ("
                    + "accNumber TEXT PRIMARY KEY, "
                    + "fullName TEXT, "
                    + "pin TEXT, "
                    + "wholeBalance INT, "
                    + "cents INT)"
            );

            conn.createStatement().execute(
                    "INSERT INTO accounts VALUES ('"
                            + acc.getAccNumber()
                            + "', '" + acc.getFullName()
                            + "', '" + acc.getPin()
                            + "', " + acc.getWholeBalance()
                            + ", " + acc.getCents() + ")"
            );



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static Account readAccount(String accNumber) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:data.db");
            ResultSet res = conn.createStatement().executeQuery(
                    "SELECT * FROM accounts WHERE accNumber = '" + accNumber + "'"
            );

            return new Account(
                    res.getString("accNumber"),
                    res.getString("fullName"),
                    res.getString("pin"),
                    res.getInt("wholeBalance"),
                    res.getInt("cents")
            );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
