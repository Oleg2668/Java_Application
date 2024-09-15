package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();

        try {
            // Додавання співробітників
            employeeDAO.addEmployee("John Doe", 30, "Developer", 5000.00f);
            employeeDAO.addEmployee("Jane Doe", 25, "Designer", 4000.00f);

            // Отримання всіх співробітників
            System.out.println("Список всіх співробітників:");
            employeeDAO.getAllEmployees();

            // Оновлення даних співробітника
            employeeDAO.updateEmployee(1, "John Smith", 31, "Senior Developer", 6000.00f);

            // Видалення співробітника
            employeeDAO.deleteEmployee(2);

            // Отримання всіх співробітників після змін
            System.out.println("Список після оновлення:");
            employeeDAO.getAllEmployees();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
