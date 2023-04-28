package exceptions;

public class EmptyListException extends Exception {
    public EmptyListException() {}

    public EmptyListException(String message) {
        super(message);
    }

    public EmptyListException(Throwable cause) {
        super(cause);
    }

    public EmptyListException(String message, Throwable cause) {
        super(message, cause);
    }
}