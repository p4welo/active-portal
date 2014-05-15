package pl.ap.server.api;

/**
 * User: pawel.radomski
 * Date: 26.11.13
 * Time: 17:38
 */
public interface PublicApiMappings
{
   public static final String PUBLIC_PREFIX = "/public";

   public static final String SEND_EMAIL = PUBLIC_PREFIX + "/email";

   public static final String GET_CLASSES = PUBLIC_PREFIX + "/classes";

   public static final String GET_FUTURE_CLASSES = PUBLIC_PREFIX + "/classes/future";

   public static final String GET_NEWS_LIST = PUBLIC_PREFIX + "/news/list";

   public static final String GET_NEWS = PUBLIC_PREFIX + "/news/{" + ApiKeys.SID + "}";

   public static final String GET_CATEGORIES = PUBLIC_PREFIX + "/categories";

   public static final String GET_INSTRUCTORS = PUBLIC_PREFIX + "/instructors";

   public static final String GET_INSTRUCTOR_DESCRIPTION = PUBLIC_PREFIX + "/instructor/{" + ApiKeys.SID + "}/description";
}
