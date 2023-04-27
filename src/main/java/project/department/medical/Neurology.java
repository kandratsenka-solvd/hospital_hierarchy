package project.department.medical;

import org.apache.logging.log4j.Logger;
import project.person.nonResident.Patient;
import project.person.resident.medical.Doctor;
import project.person.resident.medical.Nurse;
import utils.LoggerUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Neurology extends MedicalDepartment {

    private static final Logger LOGGER;
    private static final ArrayList<Doctor> doctors = new ArrayList<>();
    private static final ArrayList<Nurse> nurses = new ArrayList<>();
    private static final ArrayList<Patient> patients = new ArrayList<>();
    protected static int bedsNumber;

    static {
        LOGGER = LoggerUtil.getLogger();
        bedsNumber = 10;
    }

    public Neurology() {}

    @Override
    public void addDoctorToList(Doctor doctor) {
        doctors.add(doctor);
    }

    @Override
    public void addPatientToList(Patient patient) {
        patients.add(patient);
    }

    @Override
    void assignDoctor(Doctor doctor, Patient patient) {
    }

    @Override
    void assignNurse(Nurse nurse, Patient patient) {

    }

    @Override
    HashSet<String> getUniqueDiagnoses() {
        HashSet<String> uniqueDiagnoses = new HashSet<>();
        ArrayList<Patient> patientList = getPatientList();
        for (Patient patient: patientList) {
            uniqueDiagnoses.add(patient.getDiagnosis());
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
                        =Neurology Department=
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
        if (!(o instanceof Neurology)) return false;
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
