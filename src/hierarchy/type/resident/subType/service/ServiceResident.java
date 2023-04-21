package hierarchy.type.resident.subType.service;

import hierarchy.type.resident.Resident;

public class ServiceResident extends Resident {

    @Override
    protected void setSalary(int Salary) {
    }

    public ServiceResident(String name, String jobTitle) {
        super(name, jobTitle);
    }
}
