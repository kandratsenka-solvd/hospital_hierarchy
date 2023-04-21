package hierarchy.type.resident.subType.medical;

public class NursingStaff extends MedicalResident {

    @Override
    protected void setSalary(int Salary) {
    }

    public NursingStaff(String name, String jobTitle) {
        super(name, jobTitle);
    }
}
