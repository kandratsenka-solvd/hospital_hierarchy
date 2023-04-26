package project.interfaces.resident;

import project.person.nonResident.subType.Patient;

public interface IDoctor {
    void examinePatient(Patient patient);
    void diagnosePatient(Patient patient);
    void prescribeMedication(Patient patient);
}
