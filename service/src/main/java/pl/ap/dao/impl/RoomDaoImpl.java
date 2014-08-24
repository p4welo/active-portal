package pl.ap.dao.impl;

import org.springframework.stereotype.Repository;
import pl.ap.dao.IRoomDao;
import pl.ap.domain.Room;

/**
 * Created by parado on 2014-08-24.
 */
@Repository(RoomDaoImpl.BEAN_NAME)
public class RoomDaoImpl extends AbstractDaoImpl<Room> implements IRoomDao
{
   public static final String BEAN_NAME = "roomDao";
}
