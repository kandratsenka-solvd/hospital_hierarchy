package project.person.resident.service;

import org.apache.logging.log4j.Logger;
import project.person.nonResident.Patient;
import utils.LoggerUtil;

public class Receptionist  extends ServiceResident {

    private static final Logger LOGGER = LoggerUtil.getLogger();

    public Receptionist() {}

    public Receptionist (String firstName,
                         String lastName,
                         String gender,
                         int personalId,
                         String birthDate,
                         String jobTitle,
                         String hireDate,
                         double salary) {
        super(firstName, lastName, gender, personalId, birthDate, jobTitle, hireDate, salary);
    }

    public void registerPatient(Patient patient) {
        LOGGER.info(String
                .format("Patient %s %s was successfully registered", patient.getFirstName(), patient.getLastName()));
    }
}