package project.enums.specialTitle;

public enum ManagerSpecialty {

    CHIEF_EXECUTIVE_OFFICER("Chief Executive Officer"),
    CHIEF_MEDICAL_OFFICER("Chief Medical Officer"),
    CHIEF_NURSING_OFFICER("Chief Nursing Officer"),
    CHIEF_FINANCIAL_OFFICER("Chief Financial Officer"),
    CHIEF_OPERATING_OFFICER("Chief Operating Officer"),
    HUMAN_RESOURCES_MANAGER("Human Resources Manager"),
    QUALITY_IMPROVEMENT_MANAGER("Quality Improvement Manager"),
    INFORMATION_TECHNOLOGY_MANAGER("Information Technology Manager");

    private final String managerJobTitle;

    ManagerSpecialty(String managerJobTitle) {
        this.managerJobTitle = managerJobTitle;
    }

    public String getManagerJobTitle() {
        return managerJobTitle;
    }
}