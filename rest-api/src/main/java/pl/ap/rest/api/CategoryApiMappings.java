package pl.ap.rest.api;

/**
 * Created by parado on 2014-10-15.
 */
public interface CategoryApiMappings
{
   public static final String CATEGORY_PREFIX = "/category";

   public static final String FIND_ALL = CATEGORY_PREFIX + CommonApiMappings.FIND_ALL_SUFFIX;

   public static final String CREATE = CATEGORY_PREFIX + CommonApiMappings.CREATE_SUFFIX;

   public static final String GET = CATEGORY_PREFIX + CommonApiMappings.GET_SUFFIX;

   public static final String ACTIVATE = CATEGORY_PREFIX + CommonApiMappings.ACTIVATE_SUFFIX;

   public static final String DEACTIVATE = CATEGORY_PREFIX + CommonApiMappings.DEACTIVATE_SUFFIX;

   public static final String UPDATE = CATEGORY_PREFIX + CommonApiMappings.UPDATE_SUFFIX;

   public static final String DELETE = CATEGORY_PREFIX + CommonApiMappings.DELETE_SUFFIX;
}
