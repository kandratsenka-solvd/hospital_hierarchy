package tests;

import collections.CustomLinkedList;
import exceptions.EmptyListException;
import org.testng.annotations.Test;
import project.department.medical.Cardiology;
import project.department.medical.MedicalDepartment;
import project.person.nonResident.Patient;
import project.person.resident.medical.Doctor;
import project.person.resident.medical.Nurse;
import utils.PersonUtil;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamTest {

    @Test
    public void testStream() throws EmptyListException {
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
        System.out.println(cardiology.getUniqueDiagnoses());

        Map<String, Integer> notEmptyDepartments = bedsByDepartment.entrySet().stream()
                .filter(e -> e.getValue() < 10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        notEmptyDepartments
                .forEach((key, value) -> System.out.printf("%s department is %s percent full.%n", key, value*10));
        cardiology.getDoctorList().stream()
                .map(e -> String.format("Doctor %s %s", e.getFirstName(), e.getLastName()))
                .forEach(System.out::println);
        cardiology.getPatientList().stream()
                .filter(e -> !Objects.equals(e.getDiagnosis(), diagnosis))
                .forEach(System.out::println);
        String matchedDiagnosis = cardiology.getPatientList().stream()
                .filter(e -> Objects.equals(e.getDiagnosis(), diagnosis))
                .findFirst()
                .toString();
        System.out.println(matchedDiagnosis);
        List<Patient> patientsSortedList = patientCustomLinkedList.stream()
                .sorted(Comparator.comparing(Patient::getFirstName))
                .toList();
        String patientsSortedListInString = patientsSortedList.stream()
                .map(Patient::getFirstName)
                .collect(Collectors.joining(", ", "", "."));
        System.out.println(patientsSortedListInString);
        Stream<String> nursesSpecialties = cardiology.getNurseList().stream()
                .map(Nurse::getMedicalSpecialty);
        System.out.println(nursesSpecialties.limit(2));
    }
}