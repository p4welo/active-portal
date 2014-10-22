package pl.ap.exception;

/**
 * Created by parado on 2014-08-22.
 */
public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
