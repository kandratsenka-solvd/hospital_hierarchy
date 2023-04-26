package project.enums;

public enum JobTitle {

    DOCTOR("doctor"),
    MANAGER("manager"),
    NURSE("nurse"),
    HR_RECRUITER("hr recruiter"),
    ACCOUNTANT("accountant"),
    JANITOR("janitor"),
    SECURITY_GUARD("security guard"),
    RECEPTIONIST("receptionist"),
    SYSTEM_ADMINISTRATOR("system administrator");


    private final String jobTitle;

    JobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }
}
