package exception;

/**
 * Created by Eric on 15/11/1.
 */
public class CourseSizeExceededException extends Exception {
    public CourseSizeExceededException() {
    }

    public CourseSizeExceededException(String message) {
        super(message);
    }

    public CourseSizeExceededException(String message, Throwable cause) {
        super(message, cause);
    }

    public CourseSizeExceededException(Throwable cause) {
        super(cause);
    }

    public CourseSizeExceededException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
