package pl.ap.web.api;

/**
 * Created by parado on 2015-05-07.
 */
public interface ReservationApiMappings {
    public static final String RESERVATION_PREFIX = "/reservation";

    public static final String EVENT_PREFIX = "/event";

    public static final String FIND_BY_DATE_RANGE = RESERVATION_PREFIX + "/findByDateRange";

    public static final String CREATE = RESERVATION_PREFIX + CommonApiMappings.CREATE_SUFFIX;

    public static final String DELETE_EVENT = EVENT_PREFIX + CommonApiMappings.DELETE_SUFFIX;
}
