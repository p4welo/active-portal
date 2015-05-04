package pl.ap.web.api;

/**
 * Created by parado on 2014-10-15.
 */
public interface NewsApiMappings
{
   public static final String NEWS_PREFIX = "/news";

   public static final String FIND_ALL = NEWS_PREFIX + CommonApiMappings.FIND_ALL_SUFFIX;

   public static final String FIND_PUBLIC = NEWS_PREFIX + "/public/list";

   public static final String CREATE = NEWS_PREFIX + CommonApiMappings.CREATE_SUFFIX;

   public static final String GET = NEWS_PREFIX + CommonApiMappings.GET_SUFFIX;

   public static final String PUBLISH = NEWS_PREFIX + CommonApiMappings.PUBLISH_SUFFIX;

   public static final String DEACTIVATE = NEWS_PREFIX + CommonApiMappings.DEACTIVATE_SUFFIX;

   public static final String UPDATE = NEWS_PREFIX + CommonApiMappings.UPDATE_SUFFIX;

   public static final String DELETE = NEWS_PREFIX + CommonApiMappings.DELETE_SUFFIX;
}
