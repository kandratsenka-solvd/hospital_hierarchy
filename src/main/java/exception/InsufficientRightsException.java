package exception;

public class InsufficientRightsException extends Exception {

    public InsufficientRightsException() {}

    public InsufficientRightsException(String message) {
        super(message);
    }

    public InsufficientRightsException(Throwable cause) {
        super(cause);
    }

    public InsufficientRightsException(String message, Throwable cause) {
        super(message, cause);
    }
}
