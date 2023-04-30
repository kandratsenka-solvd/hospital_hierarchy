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

    private static Surgery createSurgery() {
        return new Surgery();
    }

    private static Cardiology createCardiology() {
        return new Cardiology();
    }

    private static Neurology createNeurology() {
        return new Neurology();
    }

    private static Oncology createOncology() {
        return new Oncology();
    }

    private static Psychiatry createPsychiatry() {
        return new Psychiatry();
    }

    private static Pediatrics createPediatrics() {
        return new Pediatrics();
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
        bedsByDepartment.put("Surgery", Surgery.bedsNumber - createSurgery().getPatientsNumber());
        bedsByDepartment.put("Cardiology", Cardiology.bedsNumber - createCardiology().getPatientsNumber());
        bedsByDepartment.put("Neurology", Neurology.bedsNumber - createNeurology().getPatientsNumber());
        bedsByDepartment.put("Oncology", Oncology.bedsNumber - createOncology().getPatientsNumber());
        bedsByDepartment.put("Psychiatry", Psychiatry.bedsNumber - createPsychiatry().getPatientsNumber());
        bedsByDepartment.put("Pediatrics", Pediatrics.bedsNumber - createPediatrics().getPatientsNumber());
        return bedsByDepartment;
    }

    public void getFreeBedsByDepartment(String departmentName) throws DepartmentNotFoundException {
        LOGGER.info("Getting free beds by department...");
        HashMap<String, Integer> bedsByDepartment = null;
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
        allPatients.addAll(createSurgery().getPatientList());
        allPatients.addAll(createCardiology().getPatientList());
        allPatients.addAll(createNeurology().getPatientList());
        allPatients.addAll(createOncology().getPatientList());
        allPatients.addAll(createPediatrics().getPatientList());
        allPatients.addAll(createPsychiatry().getPatientList());
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
        return createSurgery().getDoctorsNumber() +
                createCardiology().getDoctorsNumber() +
                createNeurology().getDoctorsNumber() +
                createOncology().getDoctorsNumber() +
                createPsychiatry().getDoctorsNumber() +
                createPediatrics().getDoctorsNumber();
    }

    protected static int getNursesTotalNumber() {
        LOGGER.info("Getting nurses total number...");
        return createSurgery().getNursesNumber() +
                createCardiology().getNursesNumber() +
                createNeurology().getNursesNumber() +
                createOncology().getNursesNumber() +
                createPsychiatry().getNursesNumber() +
                createPediatrics().getNursesNumber();
    }

    protected static int getPatientsTotalNumber() {
        LOGGER.info("Getting patients total number...");
         return createSurgery().getPatientsNumber() +
                 createCardiology().getPatientsNumber() +
                 createNeurology().getPatientsNumber() +
                 createOncology().getPatientsNumber() +
                 createPsychiatry().getPatientsNumber() +
                 createPediatrics().getPatientsNumber();
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