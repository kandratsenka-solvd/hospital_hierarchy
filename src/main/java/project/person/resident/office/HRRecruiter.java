package project.person.resident.office;

import exception.InsufficientRightsException;
import org.apache.logging.log4j.Logger;
import project.person.resident.medical.Doctor;
import utils.LoggerUtil;

public class HRRecruiter extends OfficeResident {

    private static int accessLevel;
    private static final Logger LOGGER = LoggerUtil.getLogger();

    public HRRecruiter() {}

    public HRRecruiter (String firstName,
                        String lastName,
                        String gender,
                        int personalId,
                        String birthDate,
                        String jobTitle,
                        String hireDate,
                        double salary,
                        int accessLevel) {
        super(firstName, lastName, gender, personalId, birthDate, jobTitle, hireDate, salary);
        HRRecruiter.accessLevel = accessLevel;
    }


    public static void hireDoctor(Doctor doctor) throws InsufficientRightsException {
        if (HRRecruiter.accessLevel < OfficeResident.accessLevel) {
            throw new InsufficientRightsException("Insufficient rights to hire a doctor.");
        } else {
            LOGGER.info("Doctor was successfully hired.");
        }
    }

    public void hireNurse() {}

    public void hireManager() {}

    public void hireEmployee() {}

    public static void fireDoctor(Doctor doctor) {

    }
}