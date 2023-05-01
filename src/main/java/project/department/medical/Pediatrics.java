package project.department.medical;

import org.apache.logging.log4j.Logger;
import project.person.nonResident.Patient;
import project.person.resident.medical.Doctor;
import project.person.resident.medical.Nurse;
import utils.LoggerUtil;

import java.util.ArrayList;
import java.util.Objects;

public class Pediatrics extends MedicalDepartment {

    private static final Logger LOGGER;
    private static Pediatrics instance = null;
    private static final ArrayList<Doctor> doctors = new ArrayList<>();
    private static final ArrayList<Nurse> nurses = new ArrayList<>();
    private static final ArrayList<Patient> patients = new ArrayList<>();
    protected static final int bedsNumber;

    static {
        LOGGER = LoggerUtil.getLogger();
        bedsNumber = 10;
    }

    private Pediatrics() {}

    public static Pediatrics getInstance() {
        LOGGER.info("Getting Pediatrics class instance.");
        if (instance == null) {
            instance = new Pediatrics();
        }
        return instance;
    }

    @Override
    public ArrayList<Doctor> getDoctorList() {
        LOGGER.info("Getting pediatrics doctors list.");
        return doctors;
    }

    @Override
    public ArrayList<Nurse> getNurseList() {
        LOGGER.info("Getting pediatrics nurses list.");
        return nurses;
    }

    @Override
    public ArrayList<Patient> getPatientList() {
        LOGGER.info("Getting pediatrics patients list.");
        return patients;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), doctors, nurses, patients);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pediatrics)) return false;
        return super.equals(o);
    }
}