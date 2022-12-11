package com.rentaldb.mainApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

    private static final DBUtil instance = new DBUtil();

    private static Connection connection = null;

    private String DATABASE_HOSTNAME;
    private String DATABASE_USERNAME;
    private String DATABASE_PASSWORD;

    public static DBUtil getInstance() {
        return instance;
    }

    public void set(String hostname, String username, String password) {
        this.DATABASE_HOSTNAME = "jdbc:mysql://" + hostname;
        this.DATABASE_USERNAME = username;
        this.DATABASE_PASSWORD = password;
    }

    public void connect() throws SQLException{
        connection = DriverManager.getConnection(DATABASE_HOSTNAME, DATABASE_USERNAME, DATABASE_PASSWORD);
    }


    public void test() {
        String query = "SELECT fname, lname FROM Employee";
        try {
            Connection connection = DriverManager.getConnection(DATABASE_HOSTNAME, DATABASE_USERNAME, DATABASE_PASSWORD);
            Statement statement = connection.createStatement();
        } catch (SQLException e) {
            //System.out.println(e);
        }

    }

}
