package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    // Дані для підключення до MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/company_application";
    private static final String USER = "root"; // MySQL користувач
    private static final String PASSWORD = "26Oleg1968@"; // пароль користувача

    // Метод для підключення до бази даних
    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Підключено до бази даних!");
        } catch (SQLException e) {
            System.out.println("Помилка підключення: " + e.getMessage());
        }
        return connection;
    }

    // Метод для закриття підключення
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("З'єднання закрито.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
