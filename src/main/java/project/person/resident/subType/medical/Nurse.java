package project.person.resident.subType.medical;

import project.person.nonResident.subType.Patient;
import project.interfaces.resident.INurse;

public class Nurse extends MedicalResident implements INurse {

    private String nurseSpecialty;
    private String jobTitle;


    public Nurse(String firstName,
                 String lastName,
                 String gender,
                 int personalId,
                 String birthDate,
                 String jobTitle,
                 String nurseSpecialty,
                 String hireDate,
                 double salary) {
        super(firstName, lastName, gender, personalId, birthDate, jobTitle, nurseSpecialty, hireDate, salary);
        this.nurseSpecialty = nurseSpecialty;
    }

    @Override
    public String toString() {
        return String.format("""
                        first name: %s
                        last name: %s
                        gender: %s
                        personal Id: %s
                        birth date: %s
                        job title: %s
                        nurse specialty: %s
                        hire date: %s
                        salary: %s
                        """,
                getFirstName(), getLastName(), getGender(), getPersonalId(), getBirthDate(),
                getJobTitle(), getMedicalSpecialty(), getHireDate(), getSalary());
    }

    @Override
    public void takeVitalSigns(Patient patient) {
    }

    @Override
    public void administerMedication(Patient patient) {
    }

    @Override
    public void assistWithPatientCare(Patient patient) {
    }

    @Override
    public String getMedicalSpecialty() {
        return nurseSpecialty;
    }

    @Override
    public void setMedicalSpecialty(String nurseSpecialty) {
        this.nurseSpecialty = nurseSpecialty;
    }
}