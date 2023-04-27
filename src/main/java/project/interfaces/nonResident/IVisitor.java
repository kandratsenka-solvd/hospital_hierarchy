package project.interfaces.nonResident;

import project.person.nonResident.Patient;

public interface IVisitor {
    void checkIn();
    void visitPatient(Patient patient);
    void followHospitalRules();
}