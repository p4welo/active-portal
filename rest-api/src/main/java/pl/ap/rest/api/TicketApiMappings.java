package pl.ap.rest.api;

/**
 * Created by parado on 2015-02-24.
 */
public interface TicketApiMappings {
    public static final String TICKET_PREFIX = "/ticket";

    public static final String FIND_CUSTOMER_BY_CODE = TICKET_PREFIX + CommonApiMappings.CODE_SUFFIX + "/customer";
}
