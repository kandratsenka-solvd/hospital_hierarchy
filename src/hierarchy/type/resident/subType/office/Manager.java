package hierarchy.type.resident.subType.office;

import hierarchy.type.resident.interfaces.IManager;

public class Manager extends OfficeResident implements IManager {

    @Override
    protected void setSalary(int Salary) {

    }

    public Manager(String name, String jobTitle) {
        super(name, jobTitle);
    }

    @Override
    public void setGoals() {
    }

    @Override
    public void createStrategies() {
    }

    @Override
    public void manageBudget() {
    }
}