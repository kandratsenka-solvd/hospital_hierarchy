package project.department;

import project.department.medical.MedicalDepartment;
import project.department.office.OfficeDepartment;
import project.department.service.ServiceDepartment;

public abstract class Department {

    public static int getTotalEmployeeNumber() {
        return MedicalDepartment.getEmployeeNumber() +
                OfficeDepartment.getEmployeeNumber() +
                ServiceDepartment.getEmployeeNumber();
    }
}