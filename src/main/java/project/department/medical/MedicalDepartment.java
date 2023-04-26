package project.department.medical;

import exceptions.DoctorNotFoundException;
import exceptions.NurseNotFoundException;
import exceptions.PatientNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project.utils.LoggerUtil;
import project.person.nonResident.subType.Patient;
import project.person.resident.subType.medical.Doctor;
import project.person.resident.subType.medical.Nurse;

import java.util.ArrayList;

public class MedicalDepartment {

    private static final Logger LOGGER = LoggerUtil.getLogger();
    private ArrayList<Doctor> doctors = new ArrayList<>();
    private ArrayList<Nurse> nurses = new ArrayList<>();
    private ArrayList<Patient> patients = new ArrayList<>();
    private int bedsAvailable;

    public MedicalDepartment() {}

    public MedicalDepartment(int bedsAvailable) {
        this.bedsAvailable = bedsAvailable;
        doctors = new ArrayList<>();
        nurses = new ArrayList<>();
        patients = new ArrayList<>();
    }

    public void assignDoctor(Doctor doctor, Patient patient) throws DoctorNotFoundException, PatientNotFoundException {
        LOGGER.info("Assigning a doctor to the patient");
        if (doctors.contains(doctor) && patients.contains(patient)) {
            patient.setDoctor(doctor);
            System.out.println("Doctor " + doctor.getFirstName() + " assigned to " + patient.getFirstName() + ".");
        } else {
            if (!doctors.contains(doctor)) {
                LOGGER.error("Error when assigning a doctor to the patient");
                throw new DoctorNotFoundException("The doctor does not exist");
            } else {
                LOGGER.error("Error when assigning a doctor to the patient");
                throw new PatientNotFoundException("The patient does not exist");
            }
        }
    }

    public void assignNurse(Nurse nurse, Patient patient) throws NurseNotFoundException, PatientNotFoundException {
        LOGGER.info("Assigning a nurse to the patient");
        if (nurses.contains(nurse) && patients.contains(patient)) {
            patient.setNurse(nurse);
            System.out.println("Nurse " + nurse.getFirstName() + " assigned to " + patient.getFirstName() + ".");
        } else {
            if (!nurses.contains(nurse)) {
                LOGGER.error("Error when assigning a nurse to the patient");
                throw new NurseNotFoundException("The nurse does not exist");
            } else {
                LOGGER.error("Error when assigning a nurse to the patient");
                throw new PatientNotFoundException("The patient does not exist");
            }
        }
    }

    public int getAvailableBeds() {
        return bedsAvailable;
    }

    public ArrayList<Doctor> getDoctorList() {
        return doctors;
    }

    public void addDoctorToList(Doctor doctor) {
    }

    public ArrayList<Patient> getPatientList() {
        return patients;
    }

    public ArrayList<Nurse> getNurseList() {
        return nurses;
    }
}