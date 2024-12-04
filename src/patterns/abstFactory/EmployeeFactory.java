package patterns.abstFactory;

public class EmployeeFactory {

    public static EmployeeData getEmployee(EmployeeFactoryClass factory) {
        return factory.createEmployee();
    }
}
