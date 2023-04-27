package project.person.nonResident;

import org.apache.logging.log4j.Logger;
import project.interfaces.nonResident.IPatient;
import project.person.resident.medical.Doctor;
import project.person.resident.medical.Nurse;
import utils.LoggerUtil;

import java.util.Objects;

public class Patient extends NonResident implements IPatient {

    private static final Logger LOGGER;
    private String admissionDate;
    private String diagnosis;
    private String symptoms;

    static {
        LOGGER = LoggerUtil.getLogger();
    }

    public Patient(){}

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
        LOGGER.info("Registering at hospital...");
    }

    @Override
    public void undergoTreatment() {
        LOGGER.info("Undergoing treatment...");
    }

    @Override
    public void payBill() {
        LOGGER.info("Paying bill...");
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPersonalId());
    }

    public void setDoctor(Doctor doctor) {
        LOGGER.info(String.format("The doctor %s %s was assigned", doctor.getFirstName(), doctor.getLastName()));
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
}