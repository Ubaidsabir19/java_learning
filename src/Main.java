import config.DatabaseConfig2;
import config.DatabasesConfig1;
import employeeData.Address;
import employeeData.Department;
import employeeData.Employee;
import employeeData.Experience;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import validation.ValidationClass;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;



public class Main {

    public static Logger logManager = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {

        logManager.info("Hello World!");
        logManager.warn("Hello World!");
        logManager.debug("Hello World!");
        logManager.info("Hello World!");
        logManager.error("Hello World!");
        logManager.fatal("Hello World!");

        Employee employee = new Employee();
        Address address = new Address();
        Experience experience = new Experience();
        Department department = new Department();



        // Validation Class
        ValidationClass validation = new ValidationClass();
        validation.validation("src/validation.properties");
        validation.validation("src/config/config.properties");

        // get validation properties
        String configUser = validation.properties.getProperty("user");
        String configPassword = validation.properties.getProperty("password");
        String configUrl = validation.properties.getProperty("url");

        Scanner input = new Scanner(System.in);

        enterEmployeeMToM(input, configUrl,configUser,configPassword, employee,department);

        System.out.println("Choose which you want: ");
        System.out.println("1. Insert Employee Data");
        System.out.println("2. View Employee Data");
        System.out.println("3. Delete Employee Data");
        System.out.println("4. Update Employee Data");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");

        int inputSelection = input.nextInt();
        input.nextLine();

        switch (inputSelection) {
            case 1:
                System.out.println("Insert Employee Data: ");
                insertData( input, configUrl,configUser,configPassword, employee, address, experience, validation);
                break;
            case 2:
                System.out.println("View Employee Data: ");
                fetchData(input, configUrl,  configUser, configPassword);
//                DatabasesConfig1.fetchAllEmployees(configUrl, configUser, configPassword);
                break;
            case 3:
                System.out.println("Delete Employee Data: ");
                deleteEmployeeData(input, configUrl, configUser, configPassword);
                break;
            case 4:
                System.out.println("Update Employee Data: ");
                updateEmployeeData(input, configUrl, configUser, configPassword);
                break;
            case  5:
                System.out.println("Exit............");
                break;
            default:
//                LOGGER.warning("Invalid Choice");
                break;
        }
    }

    private static void insertData(Scanner input, String configUrl, String configUser, String configPassword, Employee employee, Address address, Experience experience, ValidationClass validationClass) throws SQLException {
        System.out.print("Enter Table Name: ");
        String inputValue = input.nextLine();
        switch (inputValue) {
            case "employee":
                enterEmployee(input, configUrl, configUser, configPassword, employee);
                break;
            case "address":
                enterAddress(input,configUrl,configUser,configPassword,address, validationClass);
                break;
            case "experience":
                enterExperienceData(input, experience, configUrl,configUser,configPassword);
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }
    }

    private static void fetchData(Scanner input, String configUrl, String configUser, String configPassword) throws SQLException {
        System.out.print("Fetch Data: Enter Table Name: ");
        String inputValue = input.nextLine();
        switch (inputValue) {
            case "employee":
                DatabasesConfig1.fetchEmployee(configUrl, configUser, configPassword);
                break;
            case "address":
                DatabasesConfig1.fetchAddress(configUrl, configUser, configPassword);
                break;
            case "experience":
                DatabasesConfig1.fetchExperience(configUrl,configUser,configPassword);
                break;
            case "all":
                DatabasesConfig1.fetchAllEmployees(configUrl,configUser,configPassword);
            default:
                System.out.println("Invalid Choice");
                break;
        }
    }



    private static void enterEmployee( Scanner input, String configUrl, String configUser, String configPassword, Employee employee) throws SQLException {

        try {
            // Name Input
            System.out.print("Enter employee name: ");
            while (true) {
                String name = input.nextLine();
                if (name.isEmpty()) {
                    System.out.print("Name cannot be empty");
                } else if (name.matches(".*\\d.*") || !name.matches("^[a-zA-Z]+$")) {
                    System.out.print("Name accept only alphabets. Please enter again: ");
                } else {
                    employee.setName(name);
                    break;
                }
            }

            // Email Input
            System.out.print("Enter employee email: ");
            while (true) {
                String email = input.nextLine();
                if (email.trim().isEmpty() || !email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                    System.out.print("Email type invalid or empty include @ or domain name (e.g, gmail.com, abc.net). Please enter again: ");
                } else {
                    employee.setEmail(email);
                    break;
                }
            }

            // Date Input
            System.out.print("Enter employee Date of Birth (yyyy-MM-dd): ");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);

            while (true) {
                String inputDate = input.nextLine().trim();
                if (inputDate.isEmpty()) {
                    System.out.print("Date of Birth cannot be empty. Please enter again in format yyyy-MM-dd: ");
                } else {
                    try {
                        Date parsedDate = dateFormat.parse(inputDate);
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(parsedDate);

                        int year = calendar.get(Calendar.YEAR);
                        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                        if (year > currentYear) {
                            System.out.print("Invalid year. The year cannot be greater than the current year. Please enter again in format yyyy-MM-dd: ");
                            continue;
                        }

                        employee.setDateOfBirth(parsedDate);
                        System.out.println("Date of Birth inserted successfully: " + parsedDate);
                        break;

                    } catch (ParseException e) {
                        System.out.print("Invalid date format. Please enter the date in yyyy-MM-dd format: ");
                    }
                }
            }

            // Age Input
            System.out.print("Enter employee age: ");
            while (true) {
                String inputAge = input.nextLine();
                if (inputAge.isEmpty()) {
                    System.out.print("Age cannot be empty. Please enter again: ");
                } else {
                    try {
                        int age = Integer.parseInt(inputAge);
                        if (age < 0 || age > 60) {
                            System.out.print("Age must be between 0 and 60. Please enter again: ");
                        } else {
                            employee.setAge(age);
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.print("Age must be an integer. Please enter again: ");
                    }
                }
            }

            // Salary Input
            System.out.print("Enter employee salary: ");
            while (true) {
                String salary = input.nextLine();
                if (salary.isEmpty()) {
                    System.out.print("Salary is empty. Please enter again: ");
                } else {
                    try {
                        double salaryData = Double.parseDouble(salary);
                        if (salaryData < 1000 || salaryData > 10000000) {
                            System.out.print("Salary must be between 0 and 10,000,000. Enter again: ");
                        } else {
                            employee.setSalary(salaryData);
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.print("Salary must be a number. Please enter again: ");
                    }
                }
            }

            // ID Input
            System.out.print("Enter employee id: ");
            while (true) {
                String id = input.nextLine();
                if (id.isEmpty()) {
                    System.out.print("ID not be empty. Please enter id: ");
                } else if (id.length() > 10) {
                    System.out.print("ID must be less than 10 characters. Please enter id: ");
                } else {
                    try {
                        int idData = Integer.parseInt(id);
                        if (idData < 0) {
                            System.out.print("ID must be greater than 0. Please enter id: ");
                        } else {
                            employee.setId(idData);
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.print("Salary must be in number. Please enter again: ");
                    }
                }
            }

            // Department Input
            System.out.print("Enter employee department: ");
            while (true) {
                String dept = input.nextLine();
                if (dept.isEmpty()) {
                    System.out.println("Department is empty. Please enter a department: ");
                } else {
                    try {
                        employee.setDepartment(dept);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.print("Invalid department. Please enter a valid department: ");
                    }
                }
            }

            // Designation Input
            System.out.print("Enter employee designation: ");
            while (true) {
                String designation = input.nextLine();
                if (!designation.trim().isEmpty()) {
                    employee.setDesignation(designation);
                    break;
                } else {
                    System.out.print("Designation not Empty. Please enter again: ");
                }
            }

            DatabasesConfig1.addEmployeeData(configUrl, configUser, configPassword, employee);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    private static void enterAddress(Scanner input, String configUrl, String configUser, String configPassword, Address address, ValidationClass validationClass) throws SQLException {
        // Phone Input
        System.out.print("Enter PhoneNo: ");
        while (true) {
            String phoneNo = input.nextLine();
            if (validationClass.validatePhoneNumber(phoneNo, "phone.pak", "phone.error")) {
                address.setPhoneNo(phoneNo);
                break;
            } else {
                System.out.print("Phone number invalid, Please enter again: ");
            }
        }

        // City Input
        System.out.print("Enter employee city: ");
        while (true) {
            String city = input.nextLine();
            if (!city.trim().isEmpty()) {
                address.setCity(city);
                break;
            } else {
                System.out.print("City not Empty. Please enter again: ");
            }
        }

        // State Input
        System.out.print("Enter employee state: ");
        while (true) {
            String state = input.nextLine();
            if (!state.trim().isEmpty()) {
                address.setState(state);
                break;
            } else {
                System.out.print("State not Empty. Please enter again: ");
            }
        }

        // Street Input
        System.out.print("Enter employee street no: ");
        while (true) {
            String street = input.nextLine();
            if (street.isEmpty()) {
                System.out.print("Street not Empty. Please enter again: ");
            } else {
                try{
                    int streetNo = Integer.parseInt(street);
                    if (streetNo < 1){
                        System.out.print("street no must be greater than 0. Please enter again: ");
                    } else {
                        address.setStreet(streetNo);
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Invalid street. Please enter a valid street: ");
                }
            }
        }

        System.out.print("Enter employee id where you want save data against: ");
        int employee_id = input.nextInt();
        DatabasesConfig1.addAddressData(configUrl,configUser, configPassword,employee_id, address);
    }

    private static void enterExperienceData(Scanner input, Experience experience, String configUrl, String configUser, String configPassword) throws SQLException {

        // Tech Name Input
        System.out.print("Enter employee working Tech name: ");
        while (true) {
            String techName = input.nextLine();
            if (!techName.trim().isEmpty()) {
                experience.setTechName(techName);
                break;
            } else {
                System.out.print("Tech name not Empty. Please enter again: ");
            }
        }

        // Role Input
        System.out.print("Enter employee position/role: ");
        while (true) {
            String position = input.nextLine();
            if (position.trim().isEmpty()) {
                System.out.print("Position not Empty. Please enter: ");
            } else {
                experience.setPosition(position);
                break;
            }
        }

        // Experience Input
        System.out.print("Enter employee experience in years: ");
        while (true) {
            int experienceYears = input.nextInt();
            if (experienceYears < 1) {
                System.out.print("Experience greater than 0. Please enter again: ");
            } else {
                experience.setExperienceYears(experienceYears);
                break;
            }
        }

        System.out.print("Enter employee id where you want save data against: ");
        int employee_id = input.nextInt();
        DatabasesConfig1.addExperienceData(configUrl, configUser, configPassword, employee_id, experience);
    }


    private static void updateEmployeeData(Scanner input, String configUrl, String configUser, String configPassword) {
        System.out.print("Enter Table name: ");
        String tableName = input.nextLine();
        System.out.print("Table update: Please enter the Employee ID: ");
        int updatedId = input.nextInt();
        input.nextLine();
        System.out.print("Please enter the column which you want to update: ");
        String columnToUpdate = input.nextLine();
        System.out.print("Please enter the new value for " + columnToUpdate + ": ");
        String updatedValue = input.nextLine();
        DatabasesConfig1.updateEmployee(configUrl, configUser, configPassword, updatedId, tableName, columnToUpdate, updatedValue);
    }

    private static void deleteEmployeeData(Scanner input, String configUrl, String configUser, String configPassword) {
        System.out.print("Enter Table name: ");
        String tableName = input.nextLine();
        System.out.print("Delete employee, please enter ID: ");
        int deletedID = input.nextInt();
        input.nextLine();
        DatabasesConfig1.deleteEmployee(configUrl, configUser, configPassword,tableName, deletedID);
    }

    // Many to many
    private static void enterEmployeeMToM( Scanner input, String configUrl, String configUser, String configPassword, Employee employee, Department department) throws SQLException {

        try {
            // Name Input
            System.out.print("Enter employee name: ");
            while (true) {
                String name = input.nextLine();
                if (name.isEmpty()) {
                    System.out.print("Name cannot be empty");
                } else if (name.matches(".*\\d.*") || !name.matches("^[a-zA-Z]+$")) {
                    System.out.print("Name accept only alphabets. Please enter again: ");
                } else {
                    employee.setName(name);
                    break;
                }
            }

            // Email Input
            System.out.print("Enter employee email: ");
            while (true) {
                String email = input.nextLine();
                if (email.trim().isEmpty() || !email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                    System.out.print("Email type invalid or empty include @ or domain name (e.g, gmail.com, abc.net). Please enter again: ");
                } else {
                    employee.setEmail(email);
                    break;
                }
            }

            // Date Input
            System.out.print("Enter employee Date of Birth (yyyy-MM-dd): ");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);

            while (true) {
                String inputDate = input.nextLine().trim();
                if (inputDate.isEmpty()) {
                    System.out.print("Date of Birth cannot be empty. Please enter again in format yyyy-MM-dd: ");
                } else {
                    try {
                        Date parsedDate = dateFormat.parse(inputDate);
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(parsedDate);

                        int year = calendar.get(Calendar.YEAR);
                        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                        if (year > currentYear) {
                            System.out.print("Invalid year. The year cannot be greater than the current year. Please enter again in format yyyy-MM-dd: ");
                            continue;
                        }

                        employee.setDateOfBirth(parsedDate);
                        System.out.println("Date of Birth inserted successfully: " + parsedDate);
                        break;

                    } catch (ParseException e) {
                        System.out.print("Invalid date format. Please enter the date in yyyy-MM-dd format: ");
                    }
                }
            }

            // Age Input
            System.out.print("Enter employee age: ");
            while (true) {
                String inputAge = input.nextLine();
                if (inputAge.isEmpty()) {
                    System.out.print("Age cannot be empty. Please enter again: ");
                } else {
                    try {
                        int age = Integer.parseInt(inputAge);
                        if (age < 0 || age > 60) {
                            System.out.print("Age must be between 0 and 60. Please enter again: ");
                        } else {
                            employee.setAge(age);
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.print("Age must be an integer. Please enter again: ");
                    }
                }
            }

            // Salary Input
            System.out.print("Enter employee salary: ");
            while (true) {
                String salary = input.nextLine();
                if (salary.isEmpty()) {
                    System.out.print("Salary is empty. Please enter again: ");
                } else {
                    try {
                        double salaryData = Double.parseDouble(salary);
                        if (salaryData < 1000 || salaryData > 10000000) {
                            System.out.print("Salary must be between 0 and 10,000,000. Enter again: ");
                        } else {
                            employee.setSalary(salaryData);
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.print("Salary must be a number. Please enter again: ");
                    }
                }
            }

            // ID Input
            System.out.print("Enter employee id: ");
            while (true) {
                String id = input.nextLine();
                if (id.isEmpty()) {
                    System.out.print("ID not be empty. Please enter id: ");
                } else if (id.length() > 10) {
                    System.out.print("ID must be less than 10 characters. Please enter id: ");
                } else {
                    try {
                        int idData = Integer.parseInt(id);
                        if (idData < 0) {
                            System.out.print("ID must be greater than 0. Please enter id: ");
                        } else {
                            employee.setId(idData);
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.print("Salary must be in number. Please enter again: ");
                    }
                }
            }

            // Department Input
            System.out.print("Enter employee department: ");
            while (true) {
                String dept = input.nextLine();
                if (dept.isEmpty()) {
                    System.out.println("Department is empty. Please enter a department: ");
                } else {
                    try {
                        employee.setDepartment(dept);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.print("Invalid department. Please enter a valid department: ");
                    }
                }
            }

            // Designation Input
            System.out.print("Enter employee designation: ");
            while (true) {
                String designation = input.nextLine();
                if (!designation.trim().isEmpty()) {
                    employee.setDesignation(designation);
                    break;
                } else {
                    System.out.print("Designation not Empty. Please enter again: ");
                }
            }

            System.out.print("Enter department name: ");
            while (true) {
                String deptName = input.nextLine();
                if (deptName.trim().isEmpty()) {
                    System.out.print("Department name invalid. Please enter again: ");
                } else {
                    department.setName(deptName);
                    break;
                }
            }

            DatabaseConfig2.insertData(configUrl, configUser, configPassword, employee, department);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}