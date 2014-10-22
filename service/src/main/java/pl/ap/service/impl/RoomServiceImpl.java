package pl.ap.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.ap.dao.IIdentifiableDao;
import pl.ap.dao.IRoomDao;
import pl.ap.domain.Room;
import pl.ap.domain.enums.ObjectStateEnum;
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
    @Transactional(readOnly = false)
    public Room update(Room r) {
        Room room = getBySid(r.getSid());
        room.setCode(r.getCode());
        room.setName(r.getName());
        return super.update(room);
    }

    @Override
    protected String[] getUpdateFields() {
        return new String[]{
                Room.FIELD_OBJECT_STATE,
                Room.FIELD_NAME,
                Room.FIELD_CODE
        };
    }
}
