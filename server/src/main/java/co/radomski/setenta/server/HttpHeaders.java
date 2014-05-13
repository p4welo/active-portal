package co.radomski.setenta.server;

/**
 * @autor Rafal Glowacz
 * @since 29.09.11
 */
public interface HttpHeaders
{
   public static final String ACCEPT = "Accept";

   public static final String ACCEPT_CHARSET = "Accept-Charset";

   public static final String ALLOW = "Allow";

   public static final String CACHE_CONTROL = "Cache-Control";

   public static final String CONTENT_DISPOSITION = "Content-Disposition";

   public static final String CONTENT_LENGTH = "Content-Length";

   public static final String CONTENT_TYPE = "Content-Type";

   public static final String DATE = "Date";

   public static final String ETAG = "ETag";

   public static final String EXPIRES = "Expires";

   public static final String IF_MODIFIED_SINCE = "If-Modified-Since";

   public static final String IF_NONE_MATCH = "If-None-Match";

   public static final String LAST_MODIFIED = "Last-Modified";

   public static final String LOCATION = "Location";

   public static final String PRAGMA = "Pragma";

   static final String X_FORWARDED_SERVER = "x-forwarded-server";

   static final String X_FORWARDED_SCHEME = "x-forwarded-scheme";

   static final String X_FORWARDED_CONTEXT = "x-forwarded-context";

   static final String X_FORWARDED_PORT = "x-forwarded-port";

}
