import hierarchy.type.resident.constants.DoctorJobTitle;
import hierarchy.type.resident.subType.medical.Doctor;

public class Main {
    public static void main(String[] args) {

        Doctor doctor = new Doctor("John Smith", DoctorJobTitle.CARDIOLOGIST);
        System.out.println(doctor.getJobTitle());
        System.out.println(doctor.getName());
    }
}