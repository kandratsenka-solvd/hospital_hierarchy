package project.interfaces.resident;

import project.person.nonResident.subType.Patient;

public interface INurse {
    void takeVitalSigns(Patient patient);
    void administerMedication(Patient patient);
    void assistWithPatientCare(Patient patient);
}