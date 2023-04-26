package project.person.nonResident.subType;

import project.person.nonResident.NonResident;
import project.interfaces.nonResident.IPatient;
import project.person.resident.subType.medical.Doctor;
import project.person.resident.subType.medical.Nurse;

public class Patient extends NonResident implements IPatient {

    private String admissionDate;
    private String diagnosis;
    private String symptoms;


    public Patient(String firstName,
                   String lastName,
                   String gender,
                   int personalId,
                   String birthDate,
                   String admissionDate,
                   String diagnosis,
                   String symptoms) {
        super(firstName, lastName, gender, personalId, birthDate);
        this.admissionDate = admissionDate;
        this.diagnosis = diagnosis;
        this.symptoms = symptoms;

    }

    @Override
    public void register() {
    }

    @Override
    public void undergoTreatment() {
    }

    @Override
    public void payBill() {
    }

    public void setDoctor(Doctor doctor) {
        System.out.printf("The doctor %s was assigned%n", doctor.getFirstName());
    }

    public void setNurse(Nurse nurse) {
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getSymptoms() {
        return symptoms;
    }

    @Override
    public String toString() {
        return String.format("""
                        first name: %s
                        last name: %s
                        gender: %s
                        personal Id: %s
                        birth date: %s
                        admission date: %s
                        disease: %s
                        symptoms: %s                        
                        """,
                getFirstName(), getLastName(), getGender(), getPersonalId(), getBirthDate(),
               getAdmissionDate(), getDiagnosis(), getSymptoms());
    }
}