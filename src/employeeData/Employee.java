package employeeData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee {
    private Address address;
    private Experience experience;
    private String name;
    private int age;
    private double salary;
    private int id;
    private String department;
    private String designation;
    private String email;
    private Date dateOfBirth;
    private List<Department> departments;

    public Employee(){
        this.address = new Address();
        this.experience = new Experience();
        this.departments = new ArrayList<>();
    }

    // Getters
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public double getSalary(){
        return salary;
    }
    public int getId(){
        return id;
    }
    public String getDepartment(){
        return department;
    }
    public String getDesignation(){
        return designation;
    }
    public String getEmail(){
        return email;
    }
    public Address getAddress() {
        return address;
    }
    public Experience getExperience() {
        return experience;
    }

    // Method
    public String getFormattedDateOfBirth() {
        if (dateOfBirth != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.format(dateOfBirth);
        } else {
            return "No Date Selected";
        }
    }

    //Setters
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
            this.age = age;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setDepartment(String department){
        this.department = department;
    }
    public void setDesignation(String designation){
        this.designation = designation;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setExperience(Experience experience){
        this.experience = experience;
    }
    public void setDateOfBirth(Date dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void addDepartment(Department department) {
        if (!departments.contains(department)) {
            departments.add(department);
            department.addEmployee(this);
        }
    }

    public void removeDepartment(Department department) {
        if (departments.contains(department)) {
            departments.remove(department);
            department.removeEmployee(this);
        }
    }


    public void display(){
        System.out.println("\nEmployee Details:");
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("DateOfBirth: " + getFormattedDateOfBirth());
        System.out.println("Age: " + getAge());
        System.out.println("Salary: " + getSalary());
        System.out.println("ID: " +  getId());
        System.out.println("Department: " + getDepartment());
        System.out.println("Designation: " + getDesignation());
        System.out.println("Address: " + getAddress().getPhoneNo());
        System.out.println("City: " + getAddress().getCity());
        System.out.println("State: " + getAddress().getState());
        System.out.println("State: " + getAddress().getStreet());
        System.out.println("Position: " + getExperience().getPosition());
        System.out.println("Experience in Years: " + getExperience().getExperienceYears());
        System.out.println("Tech Name: " + getExperience().getTechName());
    }
}
