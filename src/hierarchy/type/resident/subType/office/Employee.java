package hierarchy.type.resident.subType.office;

public class Employee extends OfficeResident {

    @Override
    protected void setSalary(int Salary) {
    }

    public Employee(String name, String jobTitle) {
        super(name, jobTitle);
    }
}
