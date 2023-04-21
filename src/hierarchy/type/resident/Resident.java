package hierarchy.type.resident;

import hierarchy.Person;

public abstract class Resident extends Person {

    private String jobTitle;

    public Resident(String name, String jobTitle) {
        super(name);
        this.jobTitle = jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }
}