package pl.ap.rest.api;

/**
 * Created by parado on 2014-10-15.
 */
public interface CustomerApiMappings {
    public static final String CUSTOMER_PREFIX = "/customer";

    public static final String FIND_ALL = CUSTOMER_PREFIX + CommonApiMappings.FIND_ALL_SUFFIX;

    public static final String CREATE = CUSTOMER_PREFIX + CommonApiMappings.CREATE_SUFFIX;

    public static final String FIND_SIMILAR = CUSTOMER_PREFIX + "/similar";

    public static final String GET = CUSTOMER_PREFIX + CommonApiMappings.GET_SUFFIX;

    public static final String UPDATE = CUSTOMER_PREFIX + CommonApiMappings.UPDATE_SUFFIX;

    public static final String DELETE = CUSTOMER_PREFIX + CommonApiMappings.DELETE_SUFFIX;

    public static final String PRESENCE = CUSTOMER_PREFIX + CommonApiMappings.SID_SUFFIX + "/presence";

    public static final String COURSES = CUSTOMER_PREFIX + CommonApiMappings.SID_SUFFIX + "/courses";

    public static final String COURSES_TO_JOIN = CUSTOMER_PREFIX + CommonApiMappings.SID_SUFFIX + "/courses/canJoin";

    public static final String COURSES_TO_REGISTER = CUSTOMER_PREFIX + CommonApiMappings.SID_SUFFIX + "/courses/canRegister";

    public static final String JOIN = CUSTOMER_PREFIX + CommonApiMappings.SID_SUFFIX + "/join";

    public static final String SUBSCRIBE = CUSTOMER_PREFIX + CommonApiMappings.SID_SUFFIX + "/subscribe";
}