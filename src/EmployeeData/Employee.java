package EmployeeData;

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

    public Employee(){
        this.address = new Address();
        this.experience = new Experience();
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
    public void setAddress(Address address){
      this.address = address;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setExperience(Experience experience){
        this.experience = experience;
    }

    public void display(){
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
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
