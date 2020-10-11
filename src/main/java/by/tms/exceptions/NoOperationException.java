package by.tms.exceptions;

public class NoOperationException extends RuntimeException {

    public NoOperationException() {
    }

    public NoOperationException(String message) {
        super(message);
    }

    public NoOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoOperationException(Throwable cause) {
        super(cause);
    }

    public NoOperationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
