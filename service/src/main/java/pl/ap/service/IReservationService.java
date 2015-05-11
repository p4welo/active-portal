package pl.ap.service;
import pl.ap.domain.Event;
import pl.ap.domain.reservation.ReservationCell;
import java.util.List;

/**
 * Created by parado on 2015-05-07.
 */
public interface IReservationService {

    List<ReservationCell> findWeekReservationList();

    ReservationCell create(Event event);
}
