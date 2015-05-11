package pl.ap.web.controller;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.Event;
import pl.ap.domain.reservation.ReservationCell;
import pl.ap.service.IReservationService;
import pl.ap.web.api.ReservationApiMappings;
import pl.ap.web.dto.EventDto;
import pl.ap.web.dto.ReservationSearchDto;

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

    @RequestMapping(value = ReservationApiMappings.FIND_BY_DATE_RANGE, method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public List<ReservationCell> findByDateRange(@RequestBody ReservationSearchDto dto) {
        LOGGER.info("findByDateRange()");
        Assert.notNull(dto);
        Assert.notNull(dto.getStart());
        Assert.notNull(dto.getEnd());
        DateTime start = DateTime.parse(dto.getStart());
        DateTime end = DateTime.parse(dto.getEnd());
        LocalDate startDate = new LocalDate(start.getYear(), start.getMonthOfYear(), start.getDayOfMonth());
        LocalDate endDate = new LocalDate(end.getYear(), end.getMonthOfYear(), end.getDayOfMonth());
        return reservationService.findByDateRange(startDate, endDate);
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
