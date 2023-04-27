package project.interfaces.resident;

import project.person.nonResident.Patient;

public interface INurse {
    void takeVitalSigns(Patient patient);
    void administerMedication(Patient patient);
    void assistWithPatientCare(Patient patient);
}