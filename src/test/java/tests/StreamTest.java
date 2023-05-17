package tests;

import collections.CustomLinkedList;
import exceptions.EmptyListException;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import project.department.medical.Cardiology;
import project.department.medical.MedicalDepartment;
import project.person.nonResident.Patient;
import project.person.resident.medical.Doctor;
import project.person.resident.medical.Nurse;
import utils.LoggerUtil;
import utils.PersonUtil;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamTest {

    @Test
    public void testCollectionsWithStreamApi() throws EmptyListException {
        final Logger LOGGER = LoggerUtil.getLogger();
        Doctor doctor1 = PersonUtil.generateDoctor();
        Doctor doctor2 = PersonUtil.generateDoctor();
        Doctor doctor3 = PersonUtil.generateDoctor();
        Patient patient1 = PersonUtil.generatePatient();
        Patient patient2 = PersonUtil.generatePatient();
        Patient patient3 = PersonUtil.generatePatient();
        Nurse nurse1 = PersonUtil.generateNurse();
        Nurse nurse2 = PersonUtil.generateNurse();
        Cardiology cardiology = Cardiology.getInstance();
        cardiology.addDoctorToList(doctor1);
        cardiology.addDoctorToList(doctor2);
        cardiology.addDoctorToList(doctor3);
        cardiology.addNurseToList(nurse1);
        cardiology.addNurseToList(nurse2);
        cardiology.addNurseToList(nurse2);
        cardiology.addPatientToList(patient1);
        cardiology.addPatientToList(patient2);
        cardiology.addPatientToList(patient3);
        cardiology.assignDoctor(doctor1, patient1);
        HashMap<String, Integer> bedsByDepartment = MedicalDepartment.getFreeBedsByDepartmentList();
        CustomLinkedList<Patient> patientCustomLinkedList = new CustomLinkedList<>();
        patientCustomLinkedList.add(0, patient1);
        patientCustomLinkedList.insertAt(0, patient2);
        patientCustomLinkedList.insertAt(0, patient3);

        String diagnosis = patient1.getDiagnosis();
        int maxInt = 10;
        LOGGER.info(cardiology.getUniqueDiagnoses());

        Map<String, Integer> notEmptyDepartments = bedsByDepartment.entrySet().stream()
                .filter(e -> e.getValue() < maxInt)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        notEmptyDepartments
                .forEach((key, value) -> LOGGER.info("{} department is {} percent full.", key, value * maxInt));
        cardiology.getDoctorList().stream()
                .map(e -> String.format("Doctor %s %s", e.getFirstName(), e.getLastName()))
                .forEach(LOGGER::info);
        cardiology.getPatientList().stream()
                .filter(e -> !Objects.equals(e.getDiagnosis(), diagnosis))
                .forEach(e -> LOGGER.info(e.toString()));
        String matchedDiagnosis = cardiology.getPatientList().stream()
                .filter(e -> Objects.equals(e.getDiagnosis(), diagnosis))
                .findFirst()
                .toString();
        LOGGER.info(matchedDiagnosis);
        List<Patient> patientsSortedList = patientCustomLinkedList.stream()
                .sorted(Comparator.comparing(Patient::getFirstName))
                .toList();
        String patientsSortedListInString = patientsSortedList.stream()
                .map(Patient::getFirstName)
                .collect(Collectors.joining(", ", "", "."));
        LOGGER.info(patientsSortedListInString);
        Stream<String> nursesSpecialties = cardiology.getNurseList().stream()
                .map(Nurse::getMedicalSpecialty);
        LOGGER.info(nursesSpecialties.limit(2));
    }
}