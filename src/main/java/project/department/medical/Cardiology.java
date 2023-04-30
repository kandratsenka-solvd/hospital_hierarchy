package project.department.medical;

import org.apache.logging.log4j.Logger;
import project.person.nonResident.Patient;
import project.person.resident.medical.Doctor;
import project.person.resident.medical.Nurse;
import utils.LoggerUtil;

import java.util.ArrayList;
import java.util.Objects;

public class Cardiology extends MedicalDepartment {

    private static final Logger LOGGER;
    private final ArrayList<Doctor> doctors = new ArrayList<>();
    private static final ArrayList<Nurse> nurses = new ArrayList<>();
    private static final ArrayList<Patient> patients = new ArrayList<>();
    protected static int bedsNumber;

    static {
        LOGGER = LoggerUtil.getLogger();
        bedsNumber = 10;
    }

    public Cardiology() {}

    @Override
    public ArrayList<Doctor> getDoctorList() {
        LOGGER.info("Getting cardiology doctors list.");
        return doctors;
    }

    @Override
    public ArrayList<Nurse> getNurseList() {
        LOGGER.info("Getting cardiology nurses list.");
        return nurses;
    }

    @Override
    public ArrayList<Patient> getPatientList() {
        LOGGER.info("Getting cardiology patients list.");
        return patients;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), doctors, nurses, patients);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cardiology)) return false;
        return super.equals(o);
    }
}