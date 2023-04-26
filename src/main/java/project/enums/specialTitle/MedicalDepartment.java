package project.enums.specialTitle;

public enum MedicalDepartment {

    CARDIOLOGY("Cardiology"),
    PEDIATRICS("Pediatrics"),
    NEUROLOGY("Neurology"),
    ONCOLOGY("Oncology"),
    PSYCHIATRY("Psychiatry"),
    SURGERY("Surgery");

    private final String departmentName;

    MedicalDepartment(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}