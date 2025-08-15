package com.dinesh;

import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;

public class DBconnection {

        private static final String url = "jdbc:mysql://localhost:3306/busbooking";
        private static final String username = "root";
        private static final String password = "Dinesh@0322";

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(url, username, password);
        }
}
