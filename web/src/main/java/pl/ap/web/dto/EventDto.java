package pl.ap.web.dto;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import pl.ap.domain.Event;
import pl.ap.domain.Room;
import pl.ap.domain.enums.EventTypeEnum;

/**
 * Created by parado on 2015-05-11.
 */
public class EventDto {

    private String date;

    private String startTime;

    private String endTime;

    private EventTypeEnum type;

    private String person;

    private String description;

    private Room room;

    public Event getEvent() {
        Event event = new Event();
        event.setDate(LocalDate.parse(date));
        event.setStartTime(LocalTime.parse(startTime));
        event.setEndTime(LocalTime.parse(endTime));
        event.setType(type);
        event.setPerson(person);
        event.setDescription(description);
        event.setRoom(room);
        return event;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public EventTypeEnum getType() {
        return type;
    }

    public void setType(EventTypeEnum type) {
        this.type = type;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
