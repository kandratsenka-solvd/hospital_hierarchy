package utils;

import com.github.javafaker.Faker;
import project.enums.JobTitle;
import project.enums.specialTitle.DoctorSpecialty;
import project.enums.specialTitle.NurseSpecialty;
import project.person.nonResident.Patient;
import project.person.resident.medical.Doctor;
import project.person.resident.medical.Nurse;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public final class PersonUtil {

    private static final Faker faker;
    private static final Random random;

    static {
        faker = new Faker();
        random = new Random();
    }

    public static Doctor generateDoctor() {
        Random random = new Random();
        ArrayList<String> specialtyList = new ArrayList<>();
        for (DoctorSpecialty specialty : DoctorSpecialty.values()) {
            specialtyList.add(specialty.getDoctorJobTitle());
        }
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String gender = faker.demographic().sex();
        int personalId = faker.number().numberBetween(100000000, 999999999);
        Date startDate = Date.from(LocalDate.of(1950, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date endDate = Date.from(LocalDate.of(2002, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthDate = dateFormat.format(faker.date().between(startDate, endDate));
        String jobTitle = JobTitle.DOCTOR.getJobTitle();
        String doctorSpecialty = specialtyList.get(random.nextInt(specialtyList.size()));
        String hireDate = LocalDate.now().minus(faker.number().numberBetween(1, 11), ChronoUnit.YEARS).toString();
        double salary = faker.number().randomDouble(2, 1000, 100000);
        return new Doctor(firstName, lastName, gender, personalId, birthDate, jobTitle, doctorSpecialty, hireDate, salary);
    }

    public static Patient generatePatient() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String gender = faker.demographic().sex();
        int personalId = faker.number().numberBetween(100000000, 999999999);
        Date startDate = Date.from(LocalDate.of(1950, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date endDate = Date.from(LocalDate.of(2002, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthDate = dateFormat.format(faker.date().between(startDate, endDate));
        String admissionDate = LocalDate.now().toString();
        String disease = faker.medical().diseaseName();
        String symptoms = faker.medical().symptoms();
        return new Patient(firstName, lastName, gender, personalId, birthDate, admissionDate, disease, symptoms);
    }

    public static Nurse generateNurse() {
        ArrayList<String> specialtyList = new ArrayList<>();
        for (NurseSpecialty specialty : NurseSpecialty.values()) {
            specialtyList.add(specialty.getNurseJobTitle());
        }
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String gender = faker.demographic().sex();
        int personalId = faker.number().numberBetween(100000000, 999999999);
        Date startDate = Date.from(LocalDate.of(1950, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date endDate = Date.from(LocalDate.of(2002, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthDate = dateFormat.format(faker.date().between(startDate, endDate));
        String jobTitle = JobTitle.NURSE.getJobTitle();
        String doctorSpecialty = specialtyList.get(random.nextInt(specialtyList.size()));
        String hireDate = LocalDate.now().minus(faker.number().numberBetween(1, 11), ChronoUnit.YEARS).toString();
        double salary = faker.number().randomDouble(2, 1000, 100000);
        return new Nurse(firstName, lastName, gender, personalId, birthDate, jobTitle, doctorSpecialty, hireDate, salary);
    }
}