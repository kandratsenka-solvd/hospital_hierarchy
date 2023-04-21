package hierarchy.type.nonResident.subType;

import hierarchy.type.nonResident.NonResident;
import hierarchy.type.nonResident.interfaces.IPatient;

public class Patient extends NonResident implements IPatient {


    public Patient(String name) {
        super(name);
    }

    @Override
    public void register() {
    }

    @Override
    public void undergoTreatment() {
    }

    @Override
    public void payBill() {
    }
}