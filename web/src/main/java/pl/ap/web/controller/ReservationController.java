package pl.ap.web.controller;

import org.apache.log4j.Logger;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.Event;
import pl.ap.domain.enums.EventTypeEnum;
import pl.ap.domain.enums.ObjectStateEnum;
import pl.ap.domain.reservation.ReservationCell;
import pl.ap.service.IReservationService;
import pl.ap.service.IRoomService;
import pl.ap.service.util.SidUtils;
import pl.ap.web.api.ReservationApiMappings;
import pl.ap.web.dto.EventDto;

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

    @RequestMapping(value = ReservationApiMappings.CREATE, method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public ReservationCell create(@RequestBody EventDto dto) {
        LOGGER.info("create()");
        Assert.notNull(dto);
        Event event = dto.getEvent();
        Assert.notNull(event.getRoom());
        return reservationService.create(event);
    }
}
