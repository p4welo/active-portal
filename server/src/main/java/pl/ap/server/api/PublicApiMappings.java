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

   //   ACTION LOG
   public static final String ACTION_NEWS_PAGE = PUBLIC_PREFIX + "/action/news";

   public static final String ACTION_INSTRUCTORS_PAGE = PUBLIC_PREFIX + "/action/instructors";

   public static final String ACTION_SCHEDULE_PAGE = PUBLIC_PREFIX + "/action/schedule";

   public static final String ACTION_PRICELIST_PAGE = PUBLIC_PREFIX + "/action/priceList";

   public static final String ACTION_SHOWS_PAGE = PUBLIC_PREFIX + "/action/shows";

   public static final String ACTION_CONTACT_PAGE = PUBLIC_PREFIX + "/action/contact";

}