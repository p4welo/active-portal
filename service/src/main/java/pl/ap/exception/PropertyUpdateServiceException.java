package pl.ap.exception;

/**
 * Created by parado on 2014-08-22.
 */
public class PropertyUpdateServiceException extends ServiceException {

    public PropertyUpdateServiceException(String message) {
        super(message);
    }

    public PropertyUpdateServiceException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
