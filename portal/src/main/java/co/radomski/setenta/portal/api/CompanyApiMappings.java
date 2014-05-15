package co.radomski.setenta.portal.api;

/**
 * Created by parado on 13.04.14.
 */
public interface CompanyApiMappings
{
   public static final String REST_PREFIX = "/rest/company";

   public static final String GET_NEWS_LIST = REST_PREFIX + "/news/list";

   public static final String CREATE_NEWS = REST_PREFIX + "/news";

   public static final String GET_NEWS = REST_PREFIX + "/news/{" + ApiKeys.SID + "}";

   public static final String GET_CURRENT_USER = REST_PREFIX + "/user/current";

   public static final String GET_MENU = REST_PREFIX + "/menu";
}
