package pl.ap.rest.api;

/**
 * Created by parado on 2014-10-21.
 */
public interface AuthorityApiMappings {
    public static final String AUTHORITY_PREFIX = "/authority";

    public static final String FIND_ALL = AUTHORITY_PREFIX + CommonApiMappings.FIND_ALL_SUFFIX;

    public static final String ROLES = AUTHORITY_PREFIX + "/role" + CommonApiMappings.FIND_ALL_SUFFIX;;
}
