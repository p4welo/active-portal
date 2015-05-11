package pl.ap.web.api;

/**
 * Created by parado on 2015-05-07.
 */
public interface ReservationApiMappings {
    public static final String RESERVATION_PREFIX = "/reservation";

    public static final String FIND_BY_DATE_RANGE = RESERVATION_PREFIX + "/findByDateRange";

    public static final String CREATE = RESERVATION_PREFIX + CommonApiMappings.CREATE_SUFFIX;
}
