package ru.liga.intership.badcode.service;

import java.sql.*;

public class SqlQuery {
    public static ResultSet getResult(String url, String userName, String password, String sql) throws SQLException {
        Connection connectionToDataBase = DriverManager.getConnection(url, userName, password);
        Statement statement = connectionToDataBase.createStatement();
        return statement.executeQuery(sql);
    }
}
