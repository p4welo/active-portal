package pl.ap.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.ap.domain.Course;
import pl.ap.domain.Event;
import pl.ap.domain.Room;
import pl.ap.domain.reservation.ReservationCell;
import pl.ap.service.ICourseService;
import pl.ap.service.IEventService;
import pl.ap.service.IReservationService;
import pl.ap.service.IRoomService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by parado on 2015-05-07.
 */
@Service(ReservationServiceImpl.BEAN_NAME)
public class ReservationServiceImpl implements IReservationService {

    public static final String BEAN_NAME = "reservationService";

    @Resource
    private ICourseService courseService;

    @Resource
    private IEventService eventService;

    @Resource
    private IRoomService roomService;

    @Override
    @Transactional(readOnly = true)
    public List<ReservationCell> findWeekReservationList() {

        List<ReservationCell> result = new ArrayList<>();
        List<Course> courses = courseService.findForSchedule();
        for (Course c : courses) {
            result.add(new ReservationCell(c));
        }
        return result;
    }

    @Override
    @Transactional(readOnly = false)
    public ReservationCell create(Event event) {
        event.setRoom(roomService.getBySid(event.getRoom().getSid()));
        event = eventService.save(event);
        return new ReservationCell(event);
    }
}
