import config.DatabasesConfig;
import employeeData.Address;
import employeeData.Employee;
import employeeData.Experience;
import validation.ValidationClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Employee employee = new Employee();
        Address address = new Address();
        Experience experience = new Experience();

        // Validation Class
        ValidationClass validation = new ValidationClass();
        validation.validation("src/validation.properties");
        validation.validation("src/config/config.properties");

        // get validation properties
        String configUser = validation.properties.getProperty("user");
        String configPassword = validation.properties.getProperty("password");
        String configUrl = validation.properties.getProperty("url");

        Scanner input = new Scanner(System.in);
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
                System.out.println("Enter Employee Data: ");
                enterEmployeeData(input, employee, address, experience, configUrl, configUser, configPassword, validation);
                break;
            case 2:
                System.out.println("View Employee Data: ");
                DatabasesConfig.fetchAllEmployees(configUrl, configUser, configPassword);
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
                System.out.println("Invalid selection.");
                break;
        }
    }


    private static void enterEmployeeData(Scanner input, Employee employee, Address address, Experience experience, String configUrl, String configUser, String configPassword,ValidationClass validation) {

        // Name Input
        System.out.print("Enter employee name: ");
        while (true) {
            String name = input.nextLine();
            if (name.isEmpty()) {
                System.out.print("Name cannot be empty. Please enter again: ");
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
            if (email.trim().isEmpty() || !email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                System.out.print("Email type invalid or empty include @ or domain name (e.g, gmail.com, abc.net). Please enter again: ");
            } else {
                employee.setEmail(email);
                break;
            }
        }

        // Phone Input
        System.out.print("Enter Phone Number: ");
        while (true) {
            String phoneNo = input.nextLine();
            if (validation.validatePhoneNumber(phoneNo, "phone.pak", "phone.error")) {
                address.setPhoneNo(phoneNo);
                break;
            } else {
                System.out.print("Phone number invalid, Please enter again: ");
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
            if (id.isEmpty()){
                System.out.print("ID not be empty. Please enter id: ");
            } else if(id.length() > 10){
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

        employee.setAddress(address);
        employee.setExperience(experience);
        addEmployee(configUrl, configUser, configPassword, employee, address, experience);
    }


    public static void addEmployee(String configUrl, String configUser, String configPassword, Employee employee, Address address, Experience experience) {
        DatabasesConfig.addEmployee(configUrl,  configUser, configPassword, employee, address, experience);
    }

    private static void updateEmployeeData(Scanner input, String configUrl, String configUser, String configPassword) {
        System.out.print("Employee update: Please enter the ID: ");
        int updatedId = input.nextInt();
        input.nextLine();
        System.out.print("Please enter the column to update (e.g., email): ");
        String columnToUpdate = input.nextLine();
        System.out.print("Please enter the new value for " + columnToUpdate + ": ");
        String updatedValue = input.nextLine();
        DatabasesConfig.updateEmployee(configUrl, configUser, configPassword, updatedId, columnToUpdate, updatedValue);
    }

    private static void deleteEmployeeData(Scanner input, String configUrl, String configUser, String configPassword) {
        System.out.print("Delete employee, please enter ID: ");
        int deletedID = input.nextInt();
        input.nextLine();
        DatabasesConfig.deleteEmployee(configUrl, configUser, configPassword, deletedID);
    }
}