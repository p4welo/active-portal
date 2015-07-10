package pl.ap.web.exceptions;

/**
 * Created by parado on 2015-05-15.
 */
public class NullParameterException extends IllegalArgumentException {
    private String field;

    public NullParameterException() {
        super(ErrorCodes.INVALID_PARAMETER);
    }

    public NullParameterException(String field) {
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
