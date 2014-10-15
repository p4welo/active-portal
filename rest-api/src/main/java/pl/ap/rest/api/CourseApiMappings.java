package pl.ap.rest.api;

/**
 * Created by parado on 2014-10-15.
 */
public interface CourseApiMappings
{
   public static final String COURSE_PREFIX = "/course";

   public static final String FIND_ALL = COURSE_PREFIX + CommonApiMappings.FIND_ALL_SUFFIX;

   public static final String FIND_IN_PROGRESS = COURSE_PREFIX + "/inProgress/list";

   public static final String FIND_REGISTRATION = COURSE_PREFIX + "/registration/list";

   public static final String CREATE = COURSE_PREFIX + CommonApiMappings.CREATE_SUFFIX;

   public static final String GET = COURSE_PREFIX + CommonApiMappings.GET_SUFFIX;

   public static final String PUBLISH = COURSE_PREFIX + CommonApiMappings.PUBLISH_SUFFIX;

   public static final String DEACTIVATE = COURSE_PREFIX + CommonApiMappings.DEACTIVATE_SUFFIX;

   public static final String UPDATE = COURSE_PREFIX + CommonApiMappings.UPDATE_SUFFIX;

   public static final String DELETE = COURSE_PREFIX + CommonApiMappings.DELETE_SUFFIX;

   public static final String SET_STATE = COURSE_PREFIX + CommonApiMappings.SID_SUFFIX + "/state";

   public static final String SET_INSTRUCTOR = COURSE_PREFIX + CommonApiMappings.SID_SUFFIX + "/instructor";

   public static final String SET_ROOM = COURSE_PREFIX + CommonApiMappings.SID_SUFFIX + "/room";
}
