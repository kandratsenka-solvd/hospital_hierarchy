package hierarchy.type.nonResident.interfaces;

import hierarchy.type.nonResident.subType.Patient;

public interface IVisitor {
    void checkIn();
    void visitPatient(Patient patient);
    void followHospitalRules();
}