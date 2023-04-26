package project.enums.specialTitle;

public enum OfficeSpecialty {

    ACCOUNTANT("accountant"),
    SYSTEM_ADMINISTRATOR("system administrator"),
    HR_RECRUITER("human resources recruiter");

    private final String officeJobTitle;

    OfficeSpecialty(String officeJobTitle) {
        this.officeJobTitle = officeJobTitle;
    }

    public String getOfficeJobTitle() {
        return officeJobTitle;
    }
}
