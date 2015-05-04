package pl.ap.web.api;

/**
 * Created by parado on 2014-10-18.
 */
public interface UserApiMappings {
    public static final String USER_PREFIX = "/user";

    public static final String FIND_ALL = USER_PREFIX + CommonApiMappings.FIND_ALL_SUFFIX;

    public static final String CREATE = USER_PREFIX + CommonApiMappings.CREATE_SUFFIX;

    public static final String GET = USER_PREFIX + CommonApiMappings.GET_SUFFIX;

    public static final String ACTIVATE = USER_PREFIX + CommonApiMappings.ACTIVATE_SUFFIX;

    public static final String DEACTIVATE = USER_PREFIX + CommonApiMappings.DEACTIVATE_SUFFIX;

    public static final String UPDATE = USER_PREFIX + CommonApiMappings.UPDATE_SUFFIX;

    public static final String DELETE = USER_PREFIX + CommonApiMappings.DELETE_SUFFIX;
}
