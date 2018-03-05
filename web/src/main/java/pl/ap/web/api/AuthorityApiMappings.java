package pl.ap.web.api;

/**
 * Created by parado on 2014-10-21.
 */
public interface AuthorityApiMappings {
    public static final String AUTHORITY_PREFIX = "/authority";

    public static final String ROLE_PREFIX = "/role";

    public static final String FIND_ALL = AUTHORITY_PREFIX + CommonApiMappings.FIND_ALL_SUFFIX;

    public static final String CURRENT_AUTHORITIES = AUTHORITY_PREFIX + "/current" + CommonApiMappings.FIND_ALL_SUFFIX;

    public static final String ROLES = ROLE_PREFIX + CommonApiMappings.FIND_ALL_SUFFIX;

    public static final String FIND_BY_ROLE = ROLE_PREFIX + CommonApiMappings.SID_SUFFIX + AUTHORITY_PREFIX + CommonApiMappings.FIND_ALL_SUFFIX;

    public static final String CHECK_AUTHORITY = ROLE_PREFIX + CommonApiMappings.SID_SUFFIX + AUTHORITY_PREFIX + "/check";

    public static final String UNCHECK_AUTHORITY = ROLE_PREFIX + CommonApiMappings.SID_SUFFIX + AUTHORITY_PREFIX + "/uncheck";
}
