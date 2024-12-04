package patterns.abstFactory;

public class WebDevFactory extends EmployeeFactoryClass{

    @Override
    public EmployeeData createEmployee() {
        return new WebDeveloper();
    }
}

