package pl.ap.web.api;

/**
 * Created by parado on 2015-05-07.
 */
public interface ReservationApiMappings {
    public static final String RESERVATION_PREFIX = "/reservation";

    public static final String FIND_WEEK_RESERVATION_LIST = RESERVATION_PREFIX + CommonApiMappings.FIND_ALL_SUFFIX;

    public static final String CREATE = RESERVATION_PREFIX + CommonApiMappings.CREATE_SUFFIX;
}
