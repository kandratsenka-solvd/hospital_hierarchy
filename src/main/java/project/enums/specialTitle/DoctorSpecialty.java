package project.enums.specialTitle;

public enum DoctorSpecialty {

    CARDIOLOGIST("cardiologist"),
    PEDIATRICIAN("pediatrician"),
    NEUROLOGIST("neurologist"),
    ONCOLOGIST("oncologist"),
    PSYCHIATRIST("psychiatrist"),
    SURGEON("surgeon");

    private final String doctorJobTitle;

    DoctorSpecialty(String doctorJobTitle) {
        this.doctorJobTitle = doctorJobTitle;
    }

    public String getDoctorJobTitle() {
        return doctorJobTitle;
    }
}

