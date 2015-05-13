package pl.ap.web.exceptions;

/**
 * Created by parado on 2015-05-13.
 */
public class SidNotFoundException extends NotFoundException {
    public SidNotFoundException() {
        super(ErrorCodes.SID_NOT_FOUND);
    }
}
