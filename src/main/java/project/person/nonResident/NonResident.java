package project.person.nonResident;

import project.person.Person;

public abstract class NonResident extends Person {

    public NonResident(){}

    public NonResident (String firstName, String lastName, String gender, int personalId, String birthDate) {
        super(firstName, lastName, gender, personalId, birthDate);
    }
}