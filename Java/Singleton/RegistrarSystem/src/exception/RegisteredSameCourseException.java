package exception;

/**
 * Created by Eric on 15/11/1.
 */
public class RegisteredSameCourseException extends Exception {
    public RegisteredSameCourseException() {
    }

    public RegisteredSameCourseException(String message) {
        super(message);
    }

    public RegisteredSameCourseException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegisteredSameCourseException(Throwable cause) {
        super(cause);
    }

    public RegisteredSameCourseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
