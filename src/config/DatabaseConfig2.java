package config;

import employeeData.Employee;

import java.sql.*;

public class DatabaseConfig2 {



    private static Connection getDatabaseConnection2(String url, String user, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection != null ? "DATABASE CONNECTED" : "Failed to connect with database");
        return connection;
    }

    public static void insertData(String url, String user, String password, Employee employee, String departmentName) {
        String insertEmployee = "INSERT INTO employee (id, name, email, age, salary, department, designation, birthdate) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String insertDepartment = "INSERT INTO department (name) VALUES (?)";
        String insertEmployeeDepartment = "INSERT INTO departmentEmployee (department_id, employee_id) VALUES (?, ?)";

        try (Connection connection = getDatabaseConnection2(url, user, password)) {

            int employeeId;
            try (PreparedStatement employeeStatement = connection.prepareStatement(insertEmployee)) {
                employeeStatement.setInt(1, employee.getId());
                employeeStatement.setString(2, employee.getName());
                employeeStatement.setString(3, employee.getEmail());
                employeeStatement.setInt(4, employee.getAge());
                employeeStatement.setDouble(5, employee.getSalary());
                employeeStatement.setString(6, employee.getDepartment());
                employeeStatement.setString(7, employee.getDesignation());
                employeeStatement.setString(8, employee.getFormattedDateOfBirth());
                employeeStatement.executeUpdate();

                employeeId = employee.getId();
            }

            // Insert department data
            int departmentId;
            try (PreparedStatement departmentStatement = connection.prepareStatement(insertDepartment, Statement.RETURN_GENERATED_KEYS)) {
                departmentStatement.setString(1, departmentName);
                departmentStatement.executeUpdate();

                try (ResultSet generatedKeys = departmentStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        departmentId = generatedKeys.getInt(1);
                    } else {
                        throw new SQLException("Failed to retrieve department ID.");
                    }
                }
            }

            // Insert into employee_department table
            try (PreparedStatement relationStatement = connection.prepareStatement(insertEmployeeDepartment)) {
                relationStatement.setInt(1, employeeId);
                relationStatement.setInt(2, departmentId);
                relationStatement.executeUpdate();
            }
            System.out.println("Data inserted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}