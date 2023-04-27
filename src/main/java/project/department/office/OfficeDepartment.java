package project.department.office;

import project.department.Department;

public abstract class OfficeDepartment extends Department {

    protected static int employeeNumber;

    static {
        employeeNumber = 10;
    }

    public static int getEmployeeNumber() {
        return employeeNumber;
    }

    public static void setEmployeeNumber(int employeeNumber) {
        OfficeDepartment.employeeNumber = employeeNumber;
    }
}