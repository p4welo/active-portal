package pl.ap.web.api;

/**
 * Created by parado on 2015-02-28.
 */
public interface TicketTypeApiMappings {
    public static final String TICKET_TYPE_PREFIX = TicketApiMappings.TICKET_PREFIX + "/type";

    public static final String FIND_ALL = TICKET_TYPE_PREFIX + CommonApiMappings.FIND_ALL_SUFFIX;

    public static final String CREATE = TICKET_TYPE_PREFIX + CommonApiMappings.CREATE_SUFFIX;

    public static final String GET = TICKET_TYPE_PREFIX + CommonApiMappings.GET_SUFFIX;

    public static final String ACTIVATE = TICKET_TYPE_PREFIX + CommonApiMappings.ACTIVATE_SUFFIX;

    public static final String DEACTIVATE = TICKET_TYPE_PREFIX + CommonApiMappings.DEACTIVATE_SUFFIX;

    public static final String UPDATE = TICKET_TYPE_PREFIX + CommonApiMappings.UPDATE_SUFFIX;

    public static final String DELETE = TICKET_TYPE_PREFIX + CommonApiMappings.DELETE_SUFFIX;
}
