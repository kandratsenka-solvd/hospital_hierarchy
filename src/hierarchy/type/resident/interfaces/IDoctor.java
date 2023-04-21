package hierarchy.type.resident.interfaces;

import hierarchy.type.nonResident.subType.Patient;

public interface IDoctor {
    void examinePatient(Patient patient);
    void diagnosePatient(Patient patient);
    void prescribeMedication(Patient patient);
}
