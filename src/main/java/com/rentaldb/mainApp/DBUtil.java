package com.rentaldb.mainApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

    private String DATABASE_URL;
    private String DATABASE_USERNAME;
    private String DATABASE_PASSWORD;

    public DBUtil(String username, String password, String url) {
        this.DATABASE_URL = url;
        this.DATABASE_USERNAME = username;
        this.DATABASE_PASSWORD = password;
    }

    public DBUtil(String username, String password) {
        this.DATABASE_URL = "45.76.5.38";
        this.DATABASE_USERNAME = username;
        this.DATABASE_PASSWORD = password;
    }

    public void test() {
        String query = "SELECT fname, lname FROM Employee";
        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            Statement statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

}
