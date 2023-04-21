package hierarchy.type.resident.subType.medical;

import hierarchy.type.nonResident.subType.Patient;
import hierarchy.type.resident.interfaces.INurse;

public class Nurse extends MedicalResident implements INurse {

    public Nurse(String name, String jobTitle) {
        super(name, jobTitle);
    }

    @Override
    public void takeVitalSigns(Patient patient) {
    }

    @Override
    public void administerMedication(Patient patient) {
    }

    @Override
    public void assistWithPatientCare(Patient patient) {
    }
}