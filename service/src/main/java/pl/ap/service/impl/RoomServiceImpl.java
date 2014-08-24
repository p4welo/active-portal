package pl.ap.service.impl;

import org.springframework.stereotype.Service;
import pl.ap.dao.IAbstractDao;
import pl.ap.dao.IRoomDao;
import pl.ap.domain.Room;
import pl.ap.service.IRoomService;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-08-24.
 */
@Service(RoomServiceImpl.BEAN_NAME)
public class RoomServiceImpl extends AbstractServiceImpl<Room> implements IRoomService
{
   public static final String BEAN_NAME = "roomService";

   @Resource
   private IRoomDao roomDao;

   @Override
   protected IAbstractDao<Room> getDao()
   {
      return roomDao;
   }
}
