package project.person.resident.service;

import project.person.resident.Resident;

public abstract class ServiceResident extends Resident {

    public ServiceResident() {}

    public ServiceResident(String firstName,
                           String lastName,
                           String gender,
                           int personalId,
                           String birthDate,
                           String jobTitle,
                           String hireDate,
                           double salary) {
        super(firstName, lastName, gender, personalId, birthDate, jobTitle, hireDate, salary);
    }
}
