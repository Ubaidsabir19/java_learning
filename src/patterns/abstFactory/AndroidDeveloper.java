package patterns.abstFactory;

public class AndroidDeveloper implements EmployeeData{

    @Override
    public int salary() {
        return 80000;
    }

    @Override
    public String empName() {
        return "Android developer";
    }
}
