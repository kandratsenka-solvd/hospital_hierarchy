package exception;

public class DepartmentNotFoundException extends NullPointerException {

    public DepartmentNotFoundException() {}

    public DepartmentNotFoundException(String message) {
        super(message);
    }

    public DepartmentNotFoundException(Throwable cause) {
        super(String.valueOf(cause));
    }
}