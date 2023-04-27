package project.person.resident.office;

import project.interfaces.resident.IManager;

public class Manager extends OfficeResident implements IManager {

    public Manager(){}
    public Manager(String firstName,
                   String lastName,
                   String gender,
                   int personalId,
                   String birthDate,
                   String jobTitle,
                   String hireDate,
                   double salary) {
        super(firstName, lastName, gender, personalId, birthDate, jobTitle, hireDate, salary);
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