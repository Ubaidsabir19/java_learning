package patterns.abstFactory;

public class ClientFactory{
    public static void main(String[] args) {

        EmployeeData e1 = EmployeeFactory.getEmployee(new AndroidDevFactory());
        e1.empName();
        e1.salary();

        EmployeeData e2 = EmployeeFactory.getEmployee(new WebDevFactory());
        e2.empName();
        e2.salary();
    }
}