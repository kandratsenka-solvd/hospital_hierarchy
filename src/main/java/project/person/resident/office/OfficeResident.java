package project.person.resident.office;

import project.person.resident.Resident;

public abstract class OfficeResident extends Resident {

    protected static int accessLevel = 5;

    public OfficeResident () {}

    public OfficeResident (String firstName,
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