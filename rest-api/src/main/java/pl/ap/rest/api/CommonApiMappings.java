package pl.ap.rest.api;

/**
 * Created by parado on 2014-10-15.
 */
public interface CommonApiMappings
{
   public static final String SID_SUFFIX = "/{" + ApiKeys.SID + "}";

   public static final String FIND_ALL_SUFFIX = "/list";

   public static final String CREATE_SUFFIX = "/create";

   public static final String GET_SUFFIX = SID_SUFFIX;

   public static final String ACTIVATE_SUFFIX = SID_SUFFIX + "/activate";

   public static final String DEACTIVATE_SUFFIX = SID_SUFFIX + "/deactivate";

   public static final String PUBLISH_SUFFIX =  SID_SUFFIX + "/publish";

   public static final String UPDATE_SUFFIX = SID_SUFFIX;

   public static final String DELETE_SUFFIX = SID_SUFFIX;
}
