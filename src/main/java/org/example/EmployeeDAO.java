package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {

    // Метод для додавання співробітника
    public void addEmployee(String name, int age, String position, float salary) throws SQLException {
        String query = "INSERT INTO employees (name, age, position, salary) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, position);
            pstmt.setFloat(4, salary);
            pstmt.executeUpdate();
        }
    }

    // Метод для отримання всіх співробітників
    public void getAllEmployees() throws SQLException {
        String query = "SELECT * FROM employees";
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement pstmt = connection.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Position: " + rs.getString("position"));
                System.out.println("Salary: " + rs.getFloat("salary"));
                System.out.println("---------");
            }
        }
    }

    // Метод для оновлення даних співробітника
    public void updateEmployee(int id, String name, int age, String position, float salary) throws SQLException {
        String query = "UPDATE employees SET name = ?, age = ?, position = ?, salary = ? WHERE id = ?";
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, position);
            pstmt.setFloat(4, salary);
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
        }
    }

    // Метод для видалення співробітника
    public void deleteEmployee(int id) throws SQLException {
        String query = "DELETE FROM employees WHERE id = ?";
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}