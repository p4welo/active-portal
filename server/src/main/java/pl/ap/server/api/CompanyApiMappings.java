package pl.ap.server.api;

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

//   ROOMS

   public static final String GET_ROOM_LIST = REST_PREFIX + "/room/list";

   public static final String CREATE_ROOM = REST_PREFIX + "/room";

   public static final String GET_ROOM = REST_PREFIX + "/room/{" + ApiKeys.SID + "}";

//   INSTRUCTORS

   public static final String GET_INSTRUCTOR_LIST = REST_PREFIX + "/instructor/list";

   public static final String CREATE_INSTRUCTOR = REST_PREFIX + "/instructor";

   public static final String GET_INSTRUCTOR = REST_PREFIX + "/instructor/{" + ApiKeys.SID + "}";

//   CATEGORIES

   public static final String GET_CATEGORY_LIST = REST_PREFIX + "/category/list";

   public static final String CREATE_CATEGORY = REST_PREFIX + "/category";

   public static final String GET_CATEGORY = REST_PREFIX + "/category/{" + ApiKeys.SID + "}";

//   STYLES

   public static final String GET_STYLE_LIST = REST_PREFIX + "/style/list";

   public static final String CREATE_STYLE = REST_PREFIX + "/style";

   public static final String GET_STYLE = REST_PREFIX + "/style/{" + ApiKeys.SID + "}";

//   DANCE CLASS

   public static final String GET_DANCE_CLASS_LIST = REST_PREFIX + "/danceClass/list";

   public static final String CREATE_DANCE_CLASS = REST_PREFIX + "/danceClass";

   public static final String GET_DANCE_CLASS = REST_PREFIX + "/danceClass/{" + ApiKeys.SID + "}";
}
