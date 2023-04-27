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

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


public abstract class MedicalDepartment extends Department {

    final static Logger LOGGER;

    static {
        LOGGER = LoggerUtil.getLogger();
    }

     public MedicalDepartment() {}

    abstract void addDoctorToList(Doctor doctor);

    abstract void addNurseToList(Nurse nurse);

    abstract void addPatientToList(Patient patient);

    abstract void assignDoctor(Doctor doctor, Patient patient);

    abstract void assignNurse(Nurse nurse, Patient patient) throws PersonNotFoundException;

    abstract HashSet<String> getUniqueDiagnoses() throws EmptyListException;

    public static HashMap<String, Integer> getFreeBedsByDepartmentList() {
        LOGGER.info("Getting free beds list by department...");
        HashMap<String, Integer> bedsByDepartment = new HashMap<>();
        bedsByDepartment.put("Surgery", Surgery.bedsNumber - Surgery.getPatientsNumber());
        bedsByDepartment.put("Cardiology", Cardiology.bedsNumber - Cardiology.getPatientsNumber());
        bedsByDepartment.put("Neurology", Neurology.bedsNumber - Neurology.getPatientsNumber());
        bedsByDepartment.put("Oncology", Oncology.bedsNumber - Oncology.getPatientsNumber());
        bedsByDepartment.put("Psychiatry", Psychiatry.bedsNumber - Psychiatry.getPatientsNumber());
        bedsByDepartment.put("Pediatrics", Pediatrics.bedsNumber - Pediatrics.getPatientsNumber());
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


    public static LinkedList<Patient> getPatientlinkedList() {
        LOGGER.info("Getting patients linked list...");
        LinkedList<Patient> allPatients = new LinkedList<>();
        allPatients.addAll(Surgery.getPatientList());
        allPatients.addAll(Cardiology.getPatientList());
        allPatients.addAll(Neurology.getPatientList());
        allPatients.addAll(Oncology.getPatientList());
        allPatients.addAll(Psychiatry.getPatientList());
        allPatients.addAll(Pediatrics.getPatientList());
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

    public static int getDoctorsTotalNumber() {
        LOGGER.info("Getting doctors total number...");
        return Surgery.getDoctorsNumber() +
                Cardiology.getDoctorsNumber() +
                Neurology.getDoctorsNumber() +
                Oncology.getDoctorsNumber() +
                Psychiatry.getDoctorsNumber() +
                Pediatrics.getDoctorsNumber();
    }

    public static int getNursesTotalNumber() {
        LOGGER.info("Getting nurses total number...");
        return Surgery.getNursesNumber() +
                Cardiology.getNursesNumber() +
                Neurology.getNursesNumber() +
                Oncology.getNursesNumber() +
                Psychiatry.getNursesNumber() +
                Pediatrics.getNursesNumber();
    }

    public static int getPatientsTotalNumber() {
        LOGGER.info("Getting patients total number...");
         return Surgery.getPatientsNumber() +
                 Cardiology.getPatientsNumber() +
                 Neurology.getPatientsNumber() +
                 Oncology.getPatientsNumber() +
                 Psychiatry.getPatientsNumber() +
                 Pediatrics.getPatientsNumber();
    }
}