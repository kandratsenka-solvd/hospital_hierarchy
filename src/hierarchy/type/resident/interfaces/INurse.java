package hierarchy.type.resident.interfaces;

import hierarchy.type.nonResident.subType.Patient;

public interface INurse {
    void takeVitalSigns(Patient patient);
    void administerMedication(Patient patient);
    void assistWithPatientCare(Patient patient);
}