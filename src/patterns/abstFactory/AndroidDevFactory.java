package patterns.abstFactory;

public class AndroidDevFactory extends EmployeeFactoryClass{

    @Override
    public EmployeeData createEmployee() {
        return new AndroidDeveloper();
    }
}
