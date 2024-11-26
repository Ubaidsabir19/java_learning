package config;

import employeeData.Address;
import employeeData.Employee;
import employeeData.Experience;
import java.sql.*;

public class DatabasesConfig {

    private static Connection getDatabaseConnection(String url, String user, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection != null ? "DATABASE CONNECTED" : "Failed to connect with database");
        return connection;
    }

    public static void addEmployee(String url, String user, String password, Employee employee, Address address, Experience experience) {
        String insertQuery = "INSERT INTO employee_data (id, name, email, phoneNo, age, salary, department, destination, city, state, street, techName, position, experienceYears, birthdate) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = getDatabaseConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, address.getPhoneNo());
            preparedStatement.setInt(5, employee.getAge());
            preparedStatement.setDouble(6, employee.getSalary());
            preparedStatement.setString(7, employee.getDepartment());
            preparedStatement.setString(8, employee.getDesignation());
            preparedStatement.setString(9, address.getCity());
            preparedStatement.setString(10, address.getState());
            preparedStatement.setInt(11, address.getStreet());
            preparedStatement.setString(12, experience.getTechName());
            preparedStatement.setString(13, experience.getPosition());
            preparedStatement.setInt(14, experience.getExperienceYears());
            preparedStatement.setString(15, employee.getFormattedDateOfBirth());

            int rowsInserted = preparedStatement.executeUpdate();
            checkRows(rowsInserted, "Employee data inserted successfully!");
        } catch (Exception e) {
            System.err.println("An error occurred while inserting employee data: " + e.getMessage());
        }
    }

    public static void fetchAllEmployees(String url, String user, String password) {
        String query = "SELECT * FROM employee_data";

        try (Connection connection = getDatabaseConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            System.out.println("Employee Data: ");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Email: " + resultSet.getString("email"));
                System.out.println("Phone: " + resultSet.getString("phoneNo"));
                System.out.println("Age: " + resultSet.getInt("age"));
                System.out.println("Salary: " + resultSet.getDouble("salary"));
                System.out.println("Department: " + resultSet.getString("department"));
                System.out.println("Designation: " + resultSet.getString("destination"));
                System.out.println("City: " + resultSet.getString("city"));
                System.out.println("State: " + resultSet.getString("state"));
                System.out.println("Street: " + resultSet.getInt("street"));
                System.out.println("Tech Name: " + resultSet.getString("techName"));
                System.out.println("Position: " + resultSet.getString("position"));
                System.out.println("Experience Years: " + resultSet.getInt("experienceYears"));
                System.out.println("Date of Birth: " + resultSet.getString("birthdate"));
                System.out.println("---------------------------");
            }
        } catch (Exception e) {
            System.err.println("Error fetching employee data: " + e.getMessage());
        }
    }

    public static void updateEmployee(String url, String user, String password, int employeeId, String columnToUpdate, String newValue) {
        String updateQuery = "UPDATE employee_data SET " + columnToUpdate + " = ? WHERE id = ?";

        try (Connection connection = getDatabaseConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, newValue);
            preparedStatement.setInt(2, employeeId);

            int rowsUpdated = preparedStatement.executeUpdate();
            checkRows(rowsUpdated, "Employee data updated successfully!");
        } catch (Exception e) {
            System.err.println("An error occurred while updating employee data: " + e.getMessage());
        }
    }

    public static void deleteEmployee(String url, String user, String password, int employeeId) {
        String deleteQuery = "DELETE FROM employee_data WHERE id = ?";

        try (Connection connection = getDatabaseConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setInt(1, employeeId);

            int rowsDeleted = preparedStatement.executeUpdate();
            checkRows(rowsDeleted, "Employee with ID " + employeeId + " was successfully deleted.");
        } catch (Exception e) {
            System.err.println("An error occurred while deleting the employee: " + e.getMessage());
        }
    }

    public static void checkRows(int rowsUpdated, String msg) {
        System.out.println(rowsUpdated > 0 ? msg : "No matching employee found");
    }

}
