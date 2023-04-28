package exceptions;

public class PersonNotFoundException extends Exception {

    public PersonNotFoundException() {}

    public PersonNotFoundException(String message) {
        super(message);
    }

    public PersonNotFoundException(Throwable cause) {
        super(cause);
    }
    public PersonNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
