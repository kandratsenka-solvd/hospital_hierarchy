package project.person.resident.subType.medical;

import project.person.resident.Resident;


public abstract class MedicalResident extends Resident {

    private String medicalSpecialty;

    public MedicalResident(){}

    public MedicalResident(String firstName,
                           String lastName,
                           String gender,
                           int personalId,
                           String birthDate,
                           String jobTitle,
                           String medicalSpecialty,
                           String hireDate,
                           double salary) {
        super(firstName, lastName, gender, personalId, birthDate, jobTitle, hireDate, salary);
        this.medicalSpecialty = medicalSpecialty;
    }

    public abstract String getMedicalSpecialty();

    public void setMedicalSpecialty(String medicalSpecialty) {
        this.medicalSpecialty = medicalSpecialty;
    }
}