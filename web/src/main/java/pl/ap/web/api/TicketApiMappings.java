package pl.ap.web.api;

/**
 * Created by parado on 2015-02-24.
 */
public interface TicketApiMappings {
    public static final String TICKET_PREFIX = "/ticket";

    public static final String FIND_ALL = TICKET_PREFIX + CommonApiMappings.FIND_ALL_SUFFIX;

    public static final String CREATE = TICKET_PREFIX + CommonApiMappings.CREATE_SUFFIX;

    public static final String GET = TICKET_PREFIX + CommonApiMappings.GET_SUFFIX;

    public static final String ACTIVATE = TICKET_PREFIX + CommonApiMappings.ACTIVATE_SUFFIX;

    public static final String DEACTIVATE = TICKET_PREFIX + CommonApiMappings.DEACTIVATE_SUFFIX;

    public static final String UPDATE = TICKET_PREFIX + CommonApiMappings.UPDATE_SUFFIX;

    public static final String DELETE = TICKET_PREFIX + CommonApiMappings.DELETE_SUFFIX;

    public static final String FIND_CUSTOMER_BY_CODE = TICKET_PREFIX + CommonApiMappings.CODE_SUFFIX + "/customer";

    public static final String FIND_BY_CODE = TICKET_PREFIX + "/code" + CommonApiMappings.CODE_SUFFIX;
}
