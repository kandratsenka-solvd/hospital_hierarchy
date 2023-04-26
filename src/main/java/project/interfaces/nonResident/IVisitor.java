package project.interfaces.nonResident;

import project.person.nonResident.subType.Patient;

public interface IVisitor {
    void checkIn();
    void visitPatient(Patient patient);
    void followHospitalRules();
}