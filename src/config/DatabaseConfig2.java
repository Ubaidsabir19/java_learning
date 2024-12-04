package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig2 {

    private static Connection getDatabaseConnection2(String url, String user, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection != null ? "DATABASE CONNECTED" : "Failed to connect with database");
        return connection;
    }



}
