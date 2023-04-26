package project.person.resident;

import project.person.Person;

public abstract class Resident extends Person {

    private String jobTitle;
    private String hireDate;
    private double salary;

    public Resident() {}

    public Resident(String firstName,
                    String lastName,
                    String gender,
                    int personalId,
                    String birthDate,
                    String jobTitle,
                    String hireDate,
                    double salary) {
        super(firstName, lastName, gender, personalId, birthDate);
        this.jobTitle = jobTitle;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getHireDate() {
        return hireDate;
    }

    public String getJobTitle() {
        return jobTitle;
    }
}