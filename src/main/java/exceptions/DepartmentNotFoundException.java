package exceptions;

public class DepartmentNotFoundException extends HospitalException {

    public DepartmentNotFoundException(String message) {
        super(message);
    }
}
