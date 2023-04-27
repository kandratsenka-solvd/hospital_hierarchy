package project.person.resident.office;

public class Accountant extends OfficeResident {

    public Accountant(){}

    public Accountant(String firstName,
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
