package project.person.resident.subType.service;

public class Receptionist  extends ServiceResident {

    public Receptionist() {}

    public Receptionist (String firstName,
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
