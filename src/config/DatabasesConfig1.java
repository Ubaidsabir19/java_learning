package config;
import employeeData.Address;
import employeeData.Employee;
import employeeData.Experience;
import java.sql.*;

// One-to-Many relationship
public class DatabasesConfig1 {
    private static Connection getDatabaseConnection1(String url, String user, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection != null ? "DATABASE CONNECTED" : "Failed to connect with database");
        return connection;
    }

    public static void addEmployeeData(String url, String user, String password, Employee employee) throws SQLException {
        String insertQueryEmployee = "INSERT INTO employee (id, name, email, age, salary, department, designation, birthdate) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = getDatabaseConnection1(url, user, password);
             PreparedStatement prepStatement = connection.prepareStatement(insertQueryEmployee)) {

                prepStatement.setInt(1, employee.getId());
                prepStatement.setString(2, employee.getName());
                prepStatement.setString(3, employee.getEmail());
                prepStatement.setInt(4, employee.getAge());
                prepStatement.setDouble(5, employee.getSalary());
                prepStatement.setString(6, employee.getDepartment());
                prepStatement.setString(7, employee.getDesignation());
                prepStatement.setString(8, employee.getFormattedDateOfBirth());

                int rowsInsertedEmployee = prepStatement.executeUpdate();
                System.out.println(rowsInsertedEmployee);
                checkRows(rowsInsertedEmployee, "Employee data inserted successfully!");

        } catch (SQLException e) {
            System.err.println("An error occurred while inserting data: " + e.getMessage());
        }
    }

    public static void addAddressData(String url, String user, String password, int employeeId, Address address) throws SQLException {
        String insertQueryAddress = "INSERT INTO address (employee_id, phoneNo, state, city, street) " +
                "VALUES (?, ?, ?, ?, ?)";
        String checkEmployeeExistsQuery = "SELECT * FROM employee WHERE id = ?";

        try (Connection connection = getDatabaseConnection1(url, user, password);
             PreparedStatement checkStatement = connection.prepareStatement(checkEmployeeExistsQuery)) {

                checkStatement.setInt(1, employeeId);
                ResultSet resultSet = checkStatement.executeQuery();
               // if (resultSet.next() && resultSet.getInt(1) > 0) {
                    try (PreparedStatement addressStatement = connection.prepareStatement(insertQueryAddress)) {
                        addressStatement.setInt(1, employeeId);
                        addressStatement.setString(2, address.getPhoneNo());
                        addressStatement.setString(3, address.getState());
                        addressStatement.setString(4, address.getCity());
                        addressStatement.setInt(5, address.getStreet());

                        int rowsInsertedAddress = addressStatement.executeUpdate();
                        System.out.println(rowsInsertedAddress + " address record inserted.");
                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println("An error occurred while inserting data: " + e.getMessage());
                } catch (Exception e) {
                        e.printStackTrace();
                    }
           // }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred while connecting to the database: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();



        }
    }

    public static void addExperienceData(String url, String user, String password, int employeeId, Experience experience) throws SQLException {
        String insertQueryExperience = "INSERT INTO experience (employee_id, techName, position, years) " +
                "VALUES (?, ?, ?, ?)";
        try (Connection connection = getDatabaseConnection1(url, user, password);
             PreparedStatement experienceStatement = connection.prepareStatement(insertQueryExperience)) {

            experienceStatement.setInt(1, employeeId);
            experienceStatement.setString(2, experience.getTechName());
            experienceStatement.setString(3, experience.getPosition());
            experienceStatement.setInt(4, experience.getExperienceYears());

            int rowsInsertedExperience = experienceStatement.executeUpdate();
            System.out.println(rowsInsertedExperience + " experience record inserted.");
            } catch (SQLException e) {
                System.err.println("An error occurred while inserting data: " + e.getMessage());
            }
        }

        public static void fetchEmployee(String url, String user, String password) throws SQLException {
          String fetchEmployeeQuery = "SELECT * FROM employee";
          try (Connection connection = getDatabaseConnection1(url, user, password);
          PreparedStatement fetchEmployeeStatement = connection.prepareStatement(fetchEmployeeQuery)) {
              ResultSet resultSet = fetchEmployeeStatement.executeQuery();
              while (resultSet.next()) {
                  System.out.println("ID: " + resultSet.getInt("id"));
                  System.out.println("Name: " + resultSet.getString("name"));
                  System.out.println("Email: " + resultSet.getString("email"));
                  System.out.println("Age: " + resultSet.getInt("age"));
                  System.out.println("Salary: " + resultSet.getDouble("salary"));
                  System.out.println("Department: " + resultSet.getString("department"));
                  System.out.println("Designation: " + resultSet.getString("designation"));
                  System.out.println("Birth date: " + resultSet.getString("birthdate"));
              }
          }
        }

    public static void fetchAddress(String url, String user, String password) throws SQLException {
        String fetchEmployeeQuery = "SELECT * FROM address";
        try (Connection connection = getDatabaseConnection1(url, user, password);
             PreparedStatement fetchEmployeeStatement = connection.prepareStatement(fetchEmployeeQuery)) {
            ResultSet resultSet = fetchEmployeeStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Employee_id: " + resultSet.getInt("employee_id"));
                System.out.println("street: " + resultSet.getString("street"));
                System.out.println("city: " + resultSet.getString("city"));
                System.out.println("phoneNo: " + resultSet.getString("phoneNo"));
                System.out.println("state: " + resultSet.getString("state"));
                System.out.println("------------------------------------------");
            }
        }
    }

    public static void fetchExperience(String url, String user, String password) throws SQLException {
        String fetchEmployeeQuery = "SELECT * FROM experience";
        try (Connection connection = getDatabaseConnection1(url, user, password);
             PreparedStatement fetchEmployeeStatement = connection.prepareStatement(fetchEmployeeQuery)) {
            ResultSet resultSet = fetchEmployeeStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Employee_id: " + resultSet.getInt("employee_id"));
                System.out.println("position: " + resultSet.getString("position"));
                System.out.println("years: " + resultSet.getInt("years"));
                System.out.println("techName: " + resultSet.getString("techName"));
                System.out.println("------------------------------------------");
            }
        }
    }

    public static void fetchAllEmployees(String url, String user, String password) {
        String query = """
        SELECT e.id, e.name, e.email, e.age, e.salary,
           e.department, e.designation, e.birthdate,
           a.phoneNo, a.state, a.city, a.street,
           ex.techName, ex.position, ex.years
        FROM employee e
        LEFT JOIN address a ON e.id = a.employee_id
        LEFT JOIN experience ex ON e.id = ex.employee_id
        """;

        try (Connection connection = getDatabaseConnection1(url, user, password);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Email: " + resultSet.getString("email"));
                System.out.println("Age: " + resultSet.getInt("age"));
                System.out.println("Salary: " + resultSet.getDouble("salary"));
                System.out.println("Department: " + resultSet.getString("department"));
                System.out.println("Designation: " + resultSet.getString("designation"));
                System.out.println("Date of Birth: " + resultSet.getString("birthdate"));
                System.out.println("Phone: " + resultSet.getString("phoneNo"));
                System.out.println("State: " + resultSet.getString("state"));
                System.out.println("City: " + resultSet.getString("city"));
                System.out.println("Street: " + resultSet.getInt("street"));
                System.out.println("Tech Name: " + resultSet.getString("techName"));
                System.out.println("Position: " + resultSet.getString("position"));
                System.out.println("Experience Years: " + resultSet.getInt("years"));
                System.out.println("---------------------------");
            }
        } catch (Exception e) {
            System.err.println("Error fetching employee data: " + e.getMessage());
        }
    }


    public static void updateEmployee(String url, String user, String password, int employeeId, String table, String columnToUpdate, String newValue) {
        String updateQuery = "UPDATE " + table + " SET " + columnToUpdate + " = ? WHERE employee_id = ?";

        try (Connection connection = getDatabaseConnection1(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, newValue);
            preparedStatement.setInt(2, employeeId);

            int rowsUpdated = preparedStatement.executeUpdate();
            checkRows(rowsUpdated, "Data in table " + table + " updated successfully!");
        } catch (Exception e) {
            System.err.println("An error occurred while updating data: " + e.getMessage());
        }
    }


    public static void deleteEmployee(String url, String user, String password, String tableName, int employeeId) {
        String deleteQuery = "DELETE FROM " + tableName + " WHERE employee_id = ?";

        try (Connection connection = getDatabaseConnection1(url, user, password)) {
            connection.setAutoCommit(false);

            try (PreparedStatement prepStatement = connection.prepareStatement(deleteQuery)) {
                prepStatement.setInt(1, employeeId);
                prepStatement.executeUpdate();
            }
            connection.commit();
        } catch (Exception e) {
            System.err.println("An error occurred while deleting employee: " + e.getMessage());
        }
    }

    public static void checkRows(int rowsUpdated, String msg) {
        System.out.println(rowsUpdated > 0 ? msg : "No matching found");
    }
}
