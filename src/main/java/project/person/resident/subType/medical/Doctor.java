package project.person.resident.subType.medical;

import project.person.nonResident.subType.Patient;
import project.interfaces.resident.IDoctor;

public class Doctor extends MedicalResident implements IDoctor {

    private String doctorSpecialty;

    public Doctor(){}

    public Doctor(String firstName,
                  String lastName,
                  String gender,
                  int personalId,
                  String birthDate,
                  String jobTitle,
                  String doctorSpecialty,
                  String hireDate,
                  double salary) {
        super(firstName, lastName, gender, personalId, birthDate, jobTitle, doctorSpecialty, hireDate, salary);
        this.doctorSpecialty = doctorSpecialty;
    }

    @Override
    public void examinePatient(Patient patient) {
    }

    @Override
    public void diagnosePatient(Patient patient) {
    }

    @Override
    public void prescribeMedication(Patient patient) {
    }

    @Override
    public String getMedicalSpecialty() {
        return doctorSpecialty;
    }

    @Override
    public void setMedicalSpecialty(String nurseSpecialty) {
        this.doctorSpecialty = nurseSpecialty;
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
                        doctor specialty: %s
                        hire date: %s
                        salary: %s
                        """,
                getFirstName(), getLastName(), getGender(), getPersonalId(), getBirthDate(),
                getJobTitle(), getMedicalSpecialty(), getHireDate(), getSalary());
    }

}