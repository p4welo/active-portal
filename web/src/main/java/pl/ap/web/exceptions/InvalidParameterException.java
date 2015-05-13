package pl.ap.web.exceptions;

/**
 * Created by parado on 2015-05-13.
 */
public class InvalidParameterException extends IllegalArgumentException {

    private String field;

    public InvalidParameterException() {
        super(ErrorCodes.INVALID_PARAMETER);
    }

    public InvalidParameterException(String field) {
        this();
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
