package project.department.service;

import project.department.Department;

public abstract class ServiceDepartment extends Department {

    protected static int employeeNumber;

    static {
        employeeNumber = 10;
    }

    public static int getEmployeeNumber() {
        return employeeNumber;
    }

    public static void setEmployeeNumber(int employeeNumber) {
        ServiceDepartment.employeeNumber = employeeNumber;
    }
}
