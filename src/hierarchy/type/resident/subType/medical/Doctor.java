package hierarchy.type.resident.subType.medical;

import hierarchy.type.nonResident.subType.Patient;
import hierarchy.type.resident.interfaces.IDoctor;

public class Doctor extends MedicalResident implements IDoctor {

    @Override
    protected void setSalary(int Salary) {
    }

    public Doctor(String name, String jobTitle) {
        super(name, jobTitle);
    }

    @Override
    public void examinePatient(Patient patient) {
    }

    @Override
    public void diagnosePatient(Patient patient) {
    }

    @Override
    public void prescribeMedication(Patient patient) {
    }
}