package exceptions;

public class PatientNotFoundException extends HospitalException {

    public PatientNotFoundException(String message) {
        super(message);
    }
}
