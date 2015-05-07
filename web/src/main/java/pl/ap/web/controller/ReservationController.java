package pl.ap.web.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.ap.service.IReservationService;
import pl.ap.domain.reservation.ReservationCell;
import pl.ap.web.api.ReservationApiMappings;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2015-05-07.
 */
@RestController
public class ReservationController {

    private static final Logger LOGGER = Logger.getLogger(ReservationController.class);

    @Resource
    private IReservationService reservationService;

    @RequestMapping(value = ReservationApiMappings.FIND_WEEK_RESERVATION_LIST, method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<ReservationCell> findWeekReservationList() {
        LOGGER.info("findWeekReservationList()");
        return reservationService.findWeekReservationList();
    }
}
