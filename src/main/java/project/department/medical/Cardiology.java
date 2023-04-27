package project.department.medical;

import exceptions.EmptyListException;
import exceptions.PersonNotFoundException;
import org.apache.logging.log4j.Logger;
import project.person.nonResident.Patient;
import project.person.resident.medical.Doctor;
import project.person.resident.medical.Nurse;
import utils.LoggerUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Cardiology extends MedicalDepartment {

    private static final Logger LOGGER;
    private static final ArrayList<Doctor> doctors = new ArrayList<>();
    private static final ArrayList<Nurse> nurses = new ArrayList<>();
    private static final ArrayList<Patient> patients = new ArrayList<>();
    protected static int bedsNumber;

    static {
        LOGGER = LoggerUtil.getLogger();
        bedsNumber = 10;
    }

    public Cardiology() {}

    @Override
    public void addDoctorToList(Doctor doctor) {
        doctors.add(doctor);
    }

    @Override
    public void addPatientToList(Patient patient) {
        patients.add(patient);
    }

    @Override
    public void assignDoctor(Doctor doctor, Patient patient) {
        LOGGER.info("Assigning a doctor to the patient...");
        try {
            if (doctors.contains(doctor) && patients.contains(patient)) {
                patient.setDoctor(doctor);
                LOGGER.info("Doctor " + doctor.getFirstName() + " assigned to " + patient.getFirstName() + ".");
            } else {
                if (!doctors.contains(doctor)) {
                    LOGGER.error("Error when assigning a doctor to the patient.");
                    throw new PersonNotFoundException("The doctor does not exist.");
                } else {
                    LOGGER.error("Error when assigning a doctor to the patient.");
                    throw new PersonNotFoundException("The patient does not exist.");
                }
            }
        } catch (PersonNotFoundException e) {
            LOGGER.error(e.getMessage());
        } finally {
            LOGGER.warn("Closing connections...");
        }
    }

    @Override
    public void assignNurse(Nurse nurse, Patient patient) throws PersonNotFoundException {
        LOGGER.info("Assigning a nurse to the patient");
        if (nurses.contains(nurse) && patients.contains(patient)) {
            patient.setNurse(nurse);
            System.out.println("Nurse " + nurse.getFirstName() + " assigned to " + patient.getFirstName() + ".");
        } else {
            if (!nurses.contains(nurse)) {
                LOGGER.error("Error when assigning a nurse to the patient");
                throw new PersonNotFoundException("The nurse does not exist");
            } else {
                LOGGER.error("Error when assigning a nurse to the patient");
                throw new PersonNotFoundException("The patient does not exist");
            }
        }
    }

    @Override
    HashSet<String> getUniqueDiagnoses() throws EmptyListException {
        LOGGER.info("Getting list of unique diagnoses...");
        HashSet<String> uniqueDiagnoses = new HashSet<>();
        ArrayList<Patient> patientList = getPatientList();
        for (Patient patient: patientList) {
            uniqueDiagnoses.add(patient.getDiagnosis());
        }
        if (uniqueDiagnoses.isEmpty()) {
            throw new EmptyListException("No unique diagnoses found.");
        }
        return uniqueDiagnoses;
    }

    @Override
    public void addNurseToList(Nurse nurse) {
        nurses.add(nurse);
    }

    @Override
    public String toString() {
        ArrayList<String> doctorNames = new ArrayList<>();
        ArrayList<String> nursesNames = new ArrayList<>();
        ArrayList<String> patientsNames = new ArrayList<>();
        for(Doctor doctor: getDoctorList()) {
            doctorNames.add(doctor.getFirstName() + " " + doctor.getLastName());
        }
        for(Nurse nurse: getNurseList()) {
            nursesNames.add(nurse.getFirstName() + " " + nurse.getLastName());
        }
        for(Patient patient: getPatientList()) {
            patientsNames.add(patient.getFirstName() + " " + patient.getLastName());
        }
        return String.format("""
                        =Cardiology Department=
                        Doctors: %s
                        Nurses: %s
                        Patients: %s
                        """,
                doctorNames, nursesNames, patientsNames);
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

    public ArrayList<Doctor> getDoctorList() {
        return doctors;
    }

    public ArrayList<Nurse> getNurseList() {
        return nurses;
    }

    public static ArrayList<Patient> getPatientList() {
        return patients;
    }

    public static int getDoctorsNumber() {
        return patients.size();
    }

    public static int getNursesNumber() {
        return nurses.size();
    }

    public static int getPatientsNumber() {
        return patients.size();
    }
}