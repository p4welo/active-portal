package pl.ap.service;

import org.joda.time.LocalDate;
import pl.ap.domain.Event;
import pl.ap.domain.reservation.ReservationCell;

import java.util.List;

/**
 * Created by parado on 2015-05-07.
 */
public interface IReservationService {

    List<ReservationCell> findByDateRange(LocalDate start, LocalDate end);

    ReservationCell create(Event event);
}
