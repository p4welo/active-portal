package pl.ap.web.api;

/**
 * Created by parado on 2014-10-15.
 */
public interface InstructorApiMappings
{
   public static final String INSTRUCTOR_PREFIX = "/instructor";

   public static final String FIND_ALL = INSTRUCTOR_PREFIX + CommonApiMappings.FIND_ALL_SUFFIX;

   public static final String CREATE = INSTRUCTOR_PREFIX + CommonApiMappings.CREATE_SUFFIX;

   public static final String GET = INSTRUCTOR_PREFIX + CommonApiMappings.GET_SUFFIX;

   public static final String ACTIVATE = INSTRUCTOR_PREFIX + CommonApiMappings.ACTIVATE_SUFFIX;

   public static final String DEACTIVATE = INSTRUCTOR_PREFIX + CommonApiMappings.DEACTIVATE_SUFFIX;

   public static final String UPDATE = INSTRUCTOR_PREFIX + CommonApiMappings.UPDATE_SUFFIX;

   public static final String DELETE = INSTRUCTOR_PREFIX + CommonApiMappings.DELETE_SUFFIX;

   public static final String COURSES = INSTRUCTOR_PREFIX + CommonApiMappings.SID_SUFFIX + "/courses";
}
