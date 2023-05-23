package tests;

import collection.CustomLinkedList;
import exception.EmptyListException;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import project.department.medical.Cardiology;
import project.department.medical.MedicalDepartment;
import project.person.nonResident.Patient;
import project.person.resident.medical.Doctor;
import project.person.resident.medical.Nurse;
import utils.LoggerUtil;
import utils.PersonUtil;
import java.util.HashMap;
import java.util.Map;


public class HospitalTest {

    @Test
    public void testHospital() throws EmptyListException {
        final Logger LOGGER = LoggerUtil.getLogger();
        Doctor doctor1 = PersonUtil.generateDoctor();
        Doctor doctor2 = PersonUtil.generateDoctor();
        Patient patient1 = PersonUtil.generatePatient();
        Patient patient2 = PersonUtil.generatePatient();
        Patient patient3 = PersonUtil.generatePatient();
        Nurse nurse = PersonUtil.generateNurse();
        Cardiology cardiology = Cardiology.getInstance();
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
        CustomLinkedList<Patient> patientCustomLinkedList = new CustomLinkedList<>();
        patientCustomLinkedList.add(0, patient1);
        patientCustomLinkedList.insertAt(0, patient2);
        patientCustomLinkedList.insertAt(0, patient3);
        patientCustomLinkedList.printList();
        LOGGER.info(patientCustomLinkedList.deleteAt(1));
      }
}