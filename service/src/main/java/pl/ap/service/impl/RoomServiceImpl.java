package pl.ap.service.impl;

import org.springframework.stereotype.Service;
import pl.ap.dao.IAbstractDao;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.dao.IRoomDao;
import pl.ap.domain.Room;
import pl.ap.service.IRoomService;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-08-24.
 */
@Service(RoomServiceImpl.BEAN_NAME)
public class RoomServiceImpl extends IdentifiableServiceImpl<Room> implements IRoomService {
    public static final String BEAN_NAME = "roomService";

    @Resource
    private IRoomDao roomDao;

    @Override
    protected IIdentifiableDao<Room> getDao() {
        return roomDao;
    }

    @Override
    public Room activate(Room room) {
//      TODO: change room status
        return roomDao.update(room);
    }

    @Override
    public Room deactivate(Room room) {
        //      TODO: change room status
        return roomDao.update(room);
    }

    @Override
    public Room update(Room r) {
        Room room = getBySid(r.getSid());
        room.setCode(r.getCode());
        room.setName(r.getName());
        return super.update(room);
    }
}
