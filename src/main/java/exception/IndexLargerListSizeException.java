package exception;

public class IndexLargerListSizeException extends IndexOutOfBoundsException {

    public IndexLargerListSizeException() {}

    public IndexLargerListSizeException(String message) {
        super(message);
    }

    public IndexLargerListSizeException(Throwable cause) {
        super(String.valueOf(cause));
    }
}
