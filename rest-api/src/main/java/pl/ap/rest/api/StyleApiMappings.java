package pl.ap.rest.api;

/**
 * Created by parado on 2014-10-15.
 */
public interface StyleApiMappings {
    public static final String STYLE_PREFIX = "/style";

    public static final String FIND_ALL = STYLE_PREFIX + CommonApiMappings.FIND_ALL_SUFFIX;

    public static final String CREATE = STYLE_PREFIX + CommonApiMappings.CREATE_SUFFIX;

    public static final String GET = STYLE_PREFIX + CommonApiMappings.GET_SUFFIX;

    public static final String ACTIVATE = STYLE_PREFIX + CommonApiMappings.ACTIVATE_SUFFIX;

    public static final String DEACTIVATE = STYLE_PREFIX + CommonApiMappings.DEACTIVATE_SUFFIX;

    public static final String FIND_COURSES = STYLE_PREFIX + CommonApiMappings.SID_SUFFIX + "/courses";

    public static final String FIND_ACTIVE_COURSES = STYLE_PREFIX + CommonApiMappings.SID_SUFFIX + "/courses" + CommonApiMappings.ACTIVE_SUFFIX;

    public static final String UPDATE = STYLE_PREFIX + CommonApiMappings.UPDATE_SUFFIX;

    public static final String DELETE = STYLE_PREFIX + CommonApiMappings.DELETE_SUFFIX;

    public static final String SET_CATEGORY = STYLE_PREFIX + CommonApiMappings.SID_SUFFIX + "/category";
}
