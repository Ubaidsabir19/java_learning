import EmployeeData.Address;
import EmployeeData.Employee;
import EmployeeData.Experience;
import EmployeeData.ValidationClass;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Initialize Classes
        Employee employee =  new Employee();
        Address address = new Address();
        Experience experience = new Experience();

        // Validation Class
        ValidationClass validation = new ValidationClass();
        validation.validation("src/validation.properties");


        System.out.println("Enter Employee Data:");
        Scanner input = new Scanner(System.in);

        // Name Input
        while (true) {
            System.out.print("Enter employee name: ");
            String name = input.nextLine();
            if (name.trim().isEmpty()) {
                System.out.println("Name cannot be empty. Please try again.");
            } else if (name.matches(".*\\d.*")) {
                System.out.println("Name cannot contain numbers. Please try again.");
            } else {
                employee.setName(name);
                break;
            }
        }

        // Email Input
        while (true) {
            System.out.print("Enter employee email: ");
            String email = input.nextLine();
            if (email.trim().isEmpty() || !email.contains("@") || !email.contains(".")) {
                System.out.println("Email type invalid or empty include @ . Please try again.");
            } else {
                employee.setEmail(email);
                break;
            }
        }

        // Phone Input
        while (true) {
            System.out.print("Select Country code e.g PAK, USA, UK: ");
            String country = input.nextLine();
            if (validation.validateCountry(country)) {
                System.out.print("Enter Phone Number: ");
                String phoneNo = input.nextLine();
                if (validation.validatePhoneNumber(phoneNo, country, "phone.error")) {
                    try {
                        address.setPhoneNo(phoneNo);
                        System.out.println("Phone number is valid: " + address.getPhoneNo() );
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Phone number must be numeric.");
                    }
                }
            }
        }

        // Age Input
        while (true) {
            System.out.print("Enter employee age: ");
            int age = input.nextInt();
            if (age < 0 || age > 60) {
                System.out.println("Age must be in between 0 to 60");
            } else {
                employee.setAge(age);
                break;
            }
        }

        // Salary Input
        while (true) {
            System.out.print("Enter employee salary: ");
            double salary = input.nextDouble();
            if (salary < 0 || salary > 10000000) {
                System.out.println("Salary must be in between 0 to 1 crore");
            } else {
                employee.setSalary(salary);
                break;
            }
        }

        // ID Input
        while (true) {
            System.out.print("Enter employee id: ");
            int id = input.nextInt();
            if (id < 0) {
                System.out.println("ID must be greater than 0");
            } else {
                employee.setId(id);
                break;
            }
        }

        input.nextLine();

        // Department Input
        while (true) {
            System.out.print("Enter employee department: ");
            String dept = input.nextLine();
            if (!dept.trim().isEmpty()) {
                employee.setDepartment(dept);
                break;
            }
        }

        // Designation Input
        while (true) {
            System.out.print("Enter employee designation: ");
            String designation = input.nextLine();
            if (!designation.trim().isEmpty()) {
                employee.setDesignation(designation);
                break;
            } else {
                System.out.print("Designation not Empty. Please try again. ");
            }
        }

        // City Input
        while (true) {
            System.out.print("Enter employee city: ");
            String city = input.nextLine();
            if (!city.trim().isEmpty()) {
                address.setCity(city);
                break;
            } else {
                System.out.print("City not Empty. Please try again. ");
            }
        }

        // State Input
        while (true) {
            System.out.print("Enter employee state: ");
            String state = input.nextLine();
            if (!state.trim().isEmpty()) {
                address.setState(state);
                break;
            } else {
                System.out.print("State not Empty. Please try again. ");
            }
        }

        // Street Input
        while (true) {
            System.out.print("Enter employee street no: ");
            int street = input.nextInt();
            if (street < 1) {
                System.out.print("street no must be greater than 0. Please try again. ");
            } else {
                address.setStreet(street);
                break;
            }
        }

        input.nextLine();

        // Role Input
        while (true) {
            System.out.print("Enter employee position/role: ");
            String position = input.nextLine();
            if (position.trim().isEmpty()) {
                System.out.print("Position not Empty. Please try again. ");
            } else {
                experience.setPosition(position);
                break;
            }
        }

        // Experience Input
        while (true) {
            System.out.print("Enter employee experience in years: ");
            int experienceYears = input.nextInt();
            if (experienceYears < 1) {
                System.out.print("Experience greater than o. Please try again. ");
            } else {
                experience.setExperienceYears(experienceYears);
                break;
            }
        }

        input.nextLine();

        // Tech Name Input
        while (true) {
            System.out.print("Enter employee working Tech name: ");
            String techName = input.nextLine();
            if (!techName.trim().isEmpty()) {
                experience.setTechName(techName);
                break;
            } else {
                System.out.print("Tech name not Empty. Please try again. ");
            }
        }

        employee.setAddress(address);
        employee.setExperience(experience);

        employee.display();
    }
}
