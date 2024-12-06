package com.testproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_Testing {
    private Connection conn;

    public void get_Connection() {
        try {

            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/world_population?" +
                            "user=root&password=");
            System.out.println("Successful Connection");
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("VendorError: " + sqle.getErrorCode());
        }
    }

    public static void main(String[] args) {
        Database_Testing dt = new Database_Testing();
        dt.get_Connection();
    }
}
