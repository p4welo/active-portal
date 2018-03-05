package pl.ap.web.controller;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import pl.ap.domain.Event;
import pl.ap.domain.reservation.ReservationCell;
import pl.ap.service.IEventService;
import pl.ap.service.IReservationService;
import pl.ap.web.api.ApiKeys;
import pl.ap.web.api.CommonApiMappings;
import pl.ap.web.api.ReservationApiMappings;
import pl.ap.web.dto.EventDto;
import pl.ap.web.dto.ReservationSearchDto;
import pl.ap.web.exceptions.SidNotFoundException;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2015-05-07.
 */
@RestController
@RequestMapping(value = CommonApiMappings.REST_PREFIX)
public class ReservationController extends AbstractController {

    private static final Logger LOGGER = Logger.getLogger(ReservationController.class);

    @Resource
    private IReservationService reservationService;

    @Resource
    private IEventService eventService;

    @RequestMapping(value = ReservationApiMappings.FIND_BY_DATE_RANGE, method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public List<ReservationCell> findByDateRange(@RequestBody ReservationSearchDto dto) {
        LOGGER.info("findByDateRange()");
        assertNotNull(dto, "dto");
        assertNotNull(dto.getStart(), "start");
        assertNotNull(dto.getEnd(), "end");
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
        assertNotNull(dto, "dto");
        Event event = dto.getEvent();
        assertNotNull(event.getRoom(), "room");
        return reservationService.create(event);
    }

    @RequestMapping(value = ReservationApiMappings.DELETE_EVENT, method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteEvent(@PathVariable(ApiKeys.SID) String sid) {
        LOGGER.info("delete()");
        Event event = eventService.getBySid(sid);
        assertSidObject(event);
        eventService.delete(event);
    }
}
