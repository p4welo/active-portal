package pl.ap.dao.impl;

import pl.ap.dao.IIdentifiableDao;
import pl.ap.dao.IRoomDao;
import pl.ap.dao.TestDomainObjectFactory;
import pl.ap.domain.Room;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-10-16.
 */
public class RoomDaoImplTest extends IdentifiableDaoImplTest<Room> {
    @Resource
    private IRoomDao roomDao;

    @Override
    protected IIdentifiableDao<Room> getDao() {
        return roomDao;
    }

    @Override
    protected Room getEntity() {
        return TestDomainObjectFactory.getRoom();
    }
}
