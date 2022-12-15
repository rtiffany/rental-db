package com.rentaldb.mainApp;

import java.sql.*;
import javax.sql.rowset.*;

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
        this.DATABASE_HOSTNAME = "jdbc:mysql://" + hostname + "/rentaldb";
        this.DATABASE_USERNAME = username;
        this.DATABASE_PASSWORD = password;
    }

    public void connect() throws SQLException{
        connection = DriverManager.getConnection(DATABASE_HOSTNAME, DATABASE_USERNAME, DATABASE_PASSWORD);
    }

    // Execute Database Query
    public static ResultSet dbExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        ResultSet resultSet = null;
        CachedRowSet crs = null;
        try {
            System.out.println("select statement: " + queryStmt + "\n");
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery(queryStmt);
            crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.populate(resultSet);
        } catch (SQLException e) {
            System.out.println("sql error: " + e);
            throw e;
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return crs;
    }

    // DB Update/Insert/Delete
    public static void dbExecuteUpdate(String sqlStmt) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(sqlStmt);
        } catch (SQLException e) {
            System.out.println("sql error: " + e);
            throw e;
        }
    }
}
