package pl.ap.service;

import pl.ap.domain.Room;

/**
 * Created by parado on 2014-08-24.
 */
public interface IRoomService extends IIdentifiableService<Room> {
    Room activate(Room room);

    Room deactivate(Room room);
}
