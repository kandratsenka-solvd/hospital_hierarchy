package project.person.resident.office;

import project.person.resident.medical.Doctor;

public class HRRecruiter extends OfficeResident {


    public HRRecruiter() {}

    public HRRecruiter (String firstName,
                        String lastName,
                        String gender,
                        int personalId,
                        String birthDate,
                        String jobTitle,
                        String hireDate,
                        double salary) {
        super(firstName, lastName, gender, personalId, birthDate, jobTitle, hireDate, salary);
    }


    public static void hireDoctor(Doctor doctor) {
    }

    public void hireNurse() {}

    public void hireManager() {}

    public void hireEmployee() {}

    public static void fireDoctor(Doctor doctor) {

    }



}
