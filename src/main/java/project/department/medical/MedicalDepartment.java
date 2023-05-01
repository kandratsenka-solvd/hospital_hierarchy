package project.department.medical;

import exceptions.DepartmentNotFoundException;
import exceptions.EmptyListException;
import exceptions.PersonNotFoundException;
import org.apache.logging.log4j.Logger;
import project.department.Department;
import project.person.nonResident.Patient;
import project.person.resident.medical.Doctor;
import project.person.resident.medical.Nurse;
import utils.LoggerUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


public abstract class MedicalDepartment extends Department {

    final static Logger LOGGER;

    static {
        LOGGER = LoggerUtil.getLogger();
    }

     public MedicalDepartment() {}

    abstract public ArrayList<Doctor> getDoctorList();

    abstract public ArrayList<Patient> getPatientList();

    abstract public ArrayList<Nurse> getNurseList();

    public void addDoctorToList(Doctor doctor) {
        getDoctorList().add(doctor);
    }

    public void addPatientToList(Patient patient) {
        getPatientList().add(patient);
    }

    public void addNurseToList(Nurse nurse) {
        getNurseList().add(nurse);
    }

    public int getDoctorsNumber() {
        return getDoctorList().size();
    }

    public int getNursesNumber() {
        return getNurseList().size();
    }

    public int getPatientsNumber() {
        return getPatientList().size();
    }

    private static Surgery getSurgery() {
        return Surgery.getInstance();
    }

    private static Cardiology getCardiology() {
        return Cardiology.getInstance();
    }

    private static Neurology getNeurology() {
        return Neurology.getInstance();
    }

    private static Oncology getOncology() {
        return Oncology.getInstance();
    }

    private static Psychiatry getPsychiatry() {
        return Psychiatry.getInstance();
    }

    private static Pediatrics getPediatrics() {
        return Pediatrics.getInstance();
    }

    public void assignDoctor(Doctor doctor, Patient patient) {
        LOGGER.info("Assigning a doctor to the patient...");
        try {
            if (getDoctorList().contains(doctor) && getPatientList().contains(patient)) {
                patient.setDoctor(doctor);
                LOGGER.info("Doctor " + doctor.getFirstName() + " assigned to " + patient.getFirstName() + ".");
            } else {
                if (!getDoctorList().contains(doctor)) {
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

    public void assignNurse(Nurse nurse, Patient patient) throws PersonNotFoundException {
        LOGGER.info("Assigning a nurse to the patient");
        if (getNurseList().contains(nurse) && getPatientList().contains(patient)) {
            patient.setNurse(nurse);
            System.out.println("Nurse " + nurse.getFirstName() + " assigned to " + patient.getFirstName() + ".");
        } else {
            if (!getNurseList().contains(nurse)) {
                LOGGER.error("Error when assigning a nurse to the patient");
                throw new PersonNotFoundException("The nurse does not exist");
            } else {
                LOGGER.error("Error when assigning a nurse to the patient");
                throw new PersonNotFoundException("The patient does not exist");
            }
        }
    }

    public void setDoctor(Doctor doctor, Patient patient) {
        if (getDoctorList().contains(doctor) && getPatientList().contains(patient)) {
            patient.setDoctor(doctor);
            LOGGER.info("Doctor " + doctor.getFirstName() + " assigned to " + patient.getFirstName() + ".");
        }
    }

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

    public static HashMap<String, Integer> getFreeBedsByDepartmentList() {
        LOGGER.info("Getting free beds list by department...");
        HashMap<String, Integer> bedsByDepartment = new HashMap<>();
        bedsByDepartment.put("Surgery", Surgery.bedsNumber - getSurgery().getPatientsNumber());
        bedsByDepartment.put("Cardiology", Cardiology.bedsNumber - getCardiology().getPatientsNumber());
        bedsByDepartment.put("Neurology", Neurology.bedsNumber - getNeurology().getPatientsNumber());
        bedsByDepartment.put("Oncology", Oncology.bedsNumber - getOncology().getPatientsNumber());
        bedsByDepartment.put("Psychiatry", Psychiatry.bedsNumber - getPsychiatry().getPatientsNumber());
        bedsByDepartment.put("Pediatrics", Pediatrics.bedsNumber - getPediatrics().getPatientsNumber());
        return bedsByDepartment;
    }

    public void getFreeBedsByDepartment(String departmentName) throws DepartmentNotFoundException {
        LOGGER.info("Getting free beds by department...");
        HashMap<String, Integer> bedsByDepartment;
        try {
            bedsByDepartment = getFreeBedsByDepartmentList();
            if (!bedsByDepartment.containsKey(departmentName)) {
                throw new DepartmentNotFoundException("Department not found: " + departmentName);
            }
            Integer freeBeds = bedsByDepartment.get(departmentName);
            LOGGER.info(String.format("Free beds in department %s: %s", departmentName, freeBeds.toString()));
        } catch (DepartmentNotFoundException e) {
            LOGGER.error(e.getMessage());
            throw e;
        } finally {
            LOGGER.info("Free beds by department retrieval completed.");
        }
    }

    protected static LinkedList<Patient> getPatientlinkedList() {
        LOGGER.info("Getting patients linked list...");
        LinkedList<Patient> allPatients = new LinkedList<>();
        allPatients.addAll(getSurgery().getPatientList());
        allPatients.addAll(getCardiology().getPatientList());
        allPatients.addAll(getNeurology().getPatientList());
        allPatients.addAll(getOncology().getPatientList());
        allPatients.addAll(getPediatrics().getPatientList());
        allPatients.addAll(getPsychiatry().getPatientList());
        return allPatients;
    }

    public static int getEmployeeNumber() {
        return getDoctorsTotalNumber() + getNursesTotalNumber();
    }

    public static int getFreeBedsTotalNumber() {
        LOGGER.info("Getting free beds total number...");
        return (Surgery.bedsNumber +
                Cardiology.bedsNumber +
                Neurology.bedsNumber +
                Oncology.bedsNumber +
                Psychiatry.bedsNumber +
                Pediatrics.bedsNumber) - getPatientsTotalNumber();
    }

    protected static int getDoctorsTotalNumber() {
        LOGGER.info("Getting doctors total number...");
        return getSurgery().getDoctorsNumber() +
                getCardiology().getDoctorsNumber() +
                getNeurology().getDoctorsNumber() +
                getOncology().getDoctorsNumber() +
                getPsychiatry().getDoctorsNumber() +
                getPediatrics().getDoctorsNumber();
    }

    protected static int getNursesTotalNumber() {
        LOGGER.info("Getting nurses total number...");
        return getSurgery().getNursesNumber() +
                getCardiology().getNursesNumber() +
                getNeurology().getNursesNumber() +
                getOncology().getNursesNumber() +
                getPsychiatry().getNursesNumber() +
                getPediatrics().getNursesNumber();
    }

    protected static int getPatientsTotalNumber() {
        LOGGER.info("Getting patients total number...");
         return getSurgery().getPatientsNumber() +
                 getCardiology().getPatientsNumber() +
                 getNeurology().getPatientsNumber() +
                 getOncology().getPatientsNumber() +
                 getPsychiatry().getPatientsNumber() +
                 getPediatrics().getPatientsNumber();
    }

    @Override
    public String toString(String departmentName) {
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
                        =%s Department=
                        Doctors: %s
                        Nurses: %s
                        Patients: %s
                        """,
                departmentName, doctorNames, nursesNames, patientsNames);
    }
}