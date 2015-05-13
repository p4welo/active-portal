package pl.ap.web.exceptions;

/**
 * Created by parado on 2015-05-13.
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
