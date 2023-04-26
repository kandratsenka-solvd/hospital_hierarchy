package project.person;

public abstract class Person {

    // add empty constructors: done
    // which class can be final?
    //add static fields

    private String firstName;
    private String lastName;
    private String gender;
    private int personalId;
    private String birthDate;


    public Person(String firstName, String lastName, String gender, int personalId, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.personalId = personalId;
        this.birthDate = birthDate;
    }

    public Person(){}


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public int getPersonalId() {
        return personalId;
    }
}