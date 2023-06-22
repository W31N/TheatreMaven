package com.example.theatremaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static Connection connection;

    static {
        // Выполняется при загрузке класса
        openConnection();
    }

    private static void openConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/theatre_db", "application_user", "password");
        } catch (SQLException e) {
            System.out.println("Ошибка при открытии соединения: " + e.getMessage());
        }
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при закрытии соединения: " + e.getMessage());
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}

