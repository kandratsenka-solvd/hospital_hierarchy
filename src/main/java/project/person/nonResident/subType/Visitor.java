package project.person.nonResident.subType;

import project.person.nonResident.NonResident;
import project.interfaces.nonResident.IVisitor;

public class Visitor extends NonResident implements IVisitor {

    public Visitor (String firstName, String lastName, String gender, int personalId, String birthDate) {
        super(firstName, lastName, gender, personalId, birthDate);
    }

    @Override
    public void checkIn() {

    }

    @Override
    public void visitPatient(Patient patient) {

    }

    @Override
    public void followHospitalRules() {

    }
}