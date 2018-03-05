package pl.ap.web.api;

/**
 * Created by parado on 2014-10-15.
 */
public interface RoomApiMappings
{
   public static final String ROOM_PREFIX = "/room";

   public static final String FIND_ALL = ROOM_PREFIX + CommonApiMappings.FIND_ALL_SUFFIX;

   public static final String CREATE = ROOM_PREFIX + CommonApiMappings.CREATE_SUFFIX;

   public static final String GET = ROOM_PREFIX + CommonApiMappings.GET_SUFFIX;

   public static final String ACTIVATE = ROOM_PREFIX + CommonApiMappings.ACTIVATE_SUFFIX;

   public static final String DEACTIVATE = ROOM_PREFIX + CommonApiMappings.DEACTIVATE_SUFFIX;

   public static final String UPDATE = ROOM_PREFIX + CommonApiMappings.UPDATE_SUFFIX;

   public static final String DELETE = ROOM_PREFIX + CommonApiMappings.DELETE_SUFFIX;
}
