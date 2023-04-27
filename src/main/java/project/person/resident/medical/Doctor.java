package project.person.resident.medical;

import org.apache.logging.log4j.Logger;
import project.person.nonResident.Patient;
import project.interfaces.resident.IDoctor;
import utils.LoggerUtil;

import java.util.Objects;

public class Doctor extends MedicalResident implements IDoctor {

    final static Logger LOGGER;
    private String doctorSpecialty;

    static {
        LOGGER = LoggerUtil.getLogger();
    }

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
        LOGGER.info("Examining patient...");
    }

    @Override
    public void diagnosePatient(Patient patient) {
        LOGGER.info("Diagnosing patient...");
    }

    @Override
    public void prescribeMedication(Patient patient) {
        LOGGER.info("Prescribing medication...");
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
        LOGGER.info("Getting doctor's info...");
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPersonalId());
    }
}