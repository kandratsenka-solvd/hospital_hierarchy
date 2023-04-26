import exceptions.DoctorNotFoundException;
import exceptions.NurseNotFoundException;
import exceptions.PatientNotFoundException;
import project.utils.PersonUtil;
import project.department.medical.MedicalDepartment;
import project.person.nonResident.subType.Patient;
import project.person.resident.subType.medical.Doctor;
import project.person.resident.subType.medical.Nurse;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws DoctorNotFoundException, PatientNotFoundException, NurseNotFoundException {

        Doctor doctor1 = PersonUtil.generateDoctor();
        Doctor doctor2 = PersonUtil.generateDoctor();
        Patient patient1 = PersonUtil.generatePatient();
        Patient patient2 = PersonUtil.generatePatient();
        Nurse nurse = PersonUtil.generateNurse();

        MedicalDepartment medicalDepartment = new MedicalDepartment();
        ArrayList<Doctor> doctorsList = medicalDepartment.getDoctorList();
        ArrayList<Patient> patientsList = medicalDepartment.getPatientList();
        ArrayList<Nurse> nursesList = medicalDepartment.getNurseList();

        doctorsList.add(doctor1);
        doctorsList.add(doctor2);
        patientsList.add(patient1);
        patientsList.add(patient2);
        nursesList.add(nurse);

        medicalDepartment.assignDoctor(doctor1, patient1);
        medicalDepartment.assignNurse(nurse, patient2);

        patientsList.remove(patient1);
        medicalDepartment.assignDoctor(doctor1, patient1);
    }
}