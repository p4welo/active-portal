package pl.ap.rest.api;

/**
 * Created by parado on 2014-10-15.
 */
public interface CustomerApiMappings
{
    public static final String CUSTOMER_PREFIX = "/customer";

    public static final String FIND_ALL = CUSTOMER_PREFIX + CommonApiMappings.FIND_ALL_SUFFIX;

    public static final String CREATE = CUSTOMER_PREFIX + CommonApiMappings.CREATE_SUFFIX;

    public static final String GET = CUSTOMER_PREFIX + CommonApiMappings.GET_SUFFIX;

//    public static final String ACTIVATE = CUSTOMER_PREFIX + CommonApiMappings.ACTIVATE_SUFFIX;
//
//    public static final String DEACTIVATE = CUSTOMER_PREFIX + CommonApiMappings.DEACTIVATE_SUFFIX;

    public static final String UPDATE = CUSTOMER_PREFIX + CommonApiMappings.UPDATE_SUFFIX;

    public static final String DELETE = CUSTOMER_PREFIX + CommonApiMappings.DELETE_SUFFIX;
}
