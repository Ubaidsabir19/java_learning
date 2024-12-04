package patterns.abstFactory;

public class WebDeveloper implements EmployeeData{

    @Override
    public int salary() {
        return 60000;
    }

    @Override
    public String empName() {
        return "Web Developer";
    }
}
