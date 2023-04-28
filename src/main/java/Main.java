import collections.LinkedList;
import exceptions.EmptyListException;
import org.apache.logging.log4j.Logger;
import project.department.medical.Cardiology;
import project.department.medical.MedicalDepartment;
import utils.LoggerUtil;
import utils.PersonUtil;
import project.person.nonResident.Patient;
import project.person.resident.medical.Doctor;
import project.person.resident.medical.Nurse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static project.department.medical.Cardiology.getPatientList;


public class Main {
    public static void main(String[] args) throws EmptyListException {
        final Logger LOGGER = LoggerUtil.getLogger();
        Doctor doctor1 = PersonUtil.generateDoctor();
        Doctor doctor2 = PersonUtil.generateDoctor();
        Patient patient1 = PersonUtil.generatePatient();
        Patient patient2 = PersonUtil.generatePatient();
        Patient patient3 = PersonUtil.generatePatient();
        Nurse nurse = PersonUtil.generateNurse();
        Cardiology cardiology = new Cardiology();
        cardiology.addDoctorToList(doctor1);
        cardiology.addDoctorToList(doctor2);
        cardiology.addNurseToList(nurse);
        cardiology.addPatientToList(patient1);
        cardiology.addPatientToList(patient2);
        cardiology.addPatientToList(patient3);
        cardiology.getDoctorList().remove(doctor1);
        cardiology.assignDoctor(doctor1, patient1);
        LOGGER.info("Total beds number at hospital = " + MedicalDepartment.getFreeBedsTotalNumber());
        HashMap<String, Integer> bedsByDepartment = MedicalDepartment.getFreeBedsByDepartmentList();
        for (Map.Entry<String, Integer> entry : bedsByDepartment.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            LOGGER.info(key + " = " + value);
        }
        LinkedList<String> patientLinkedList = new LinkedList<>();
        ArrayList<Patient> patientList = getPatientList();
        for (Patient patient: patientList) {
            patientLinkedList.add(0, patient.getFirstName());
        }
        LOGGER.info(patientList);
        cardiology.getFreeBedsByDepartment("abc");
    }
}