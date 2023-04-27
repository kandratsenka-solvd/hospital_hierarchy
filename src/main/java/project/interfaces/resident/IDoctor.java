package project.interfaces.resident;

import project.person.nonResident.Patient;

public interface IDoctor {
    void examinePatient(Patient patient);
    void diagnosePatient(Patient patient);
    void prescribeMedication(Patient patient);
}
