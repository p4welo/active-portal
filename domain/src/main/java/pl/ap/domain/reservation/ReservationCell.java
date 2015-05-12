package pl.ap.domain.reservation;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import pl.ap.domain.Course;
import pl.ap.domain.Event;
import pl.ap.domain.Instructor;
import pl.ap.domain.Room;
import pl.ap.domain.enums.DayEnum;
import pl.ap.domain.enums.EventTypeEnum;

import java.util.List;

/**
 * Created by parado on 2015-05-07.
 */
public class ReservationCell {

    private ReservationTypeEnum type;

    private EventTypeEnum eventType;

    private DayEnum day;

    private LocalDate date;

    private Room room;

    private String person;

    private String startTime;

    private int startHour;

    private int startMinute;

    private String endTime;

    private int endHour;

    private int endMinute;

    private String description;

    public ReservationCell(Course course, LocalDate weekStartDate) {
        this.type = ReservationTypeEnum.COURSE;
        this.day = course.getDay();
        this.date = weekStartDate.withDayOfWeek(course.getDay().ordinal() + 1);
        this.room = course.getRoom();

        List<Instructor> instructors = course.getInstructors();
        this.person = StringUtils.EMPTY;
        if (instructors != null) {
            if (instructors.size() > 0) {
                Instructor ins = instructors.get(0);
                this.person += ins.getFirstName() + " " + ins.getLastName();
                if (instructors.size() > 1) {
                    for (int i = 1; i < instructors.size(); i++) {
                        ins = instructors.get(i);
                        this.person += ", " + ins.getFirstName() + " " + ins.getLastName();
                    }
                }
            }
        }
        this.startTime = course.getStartTime();
        if (this.startTime != null && this.startTime.indexOf(":") > -1) {
            String[] start = course.getStartTime().split(":");
            this.startHour = Integer.parseInt(start[0]);
            this.startMinute = Integer.parseInt(start[1]);
        }

        this.endTime = course.getEndTime();
        if (this.endTime != null && this.endTime.indexOf(":") > -1) {
            String[] end = course.getEndTime().split(":");
            this.endHour = Integer.parseInt(end[0]);
            this.endMinute = Integer.parseInt(end[1]);
        }
        this.description = course.getStyle().getName();
    }

    public ReservationCell(Event event) {
        this.type = ReservationTypeEnum.EVENT;
        this.eventType = event.getType();
        int dayIdx = event.getDate().getDayOfWeek();
        this.day = DayEnum.values()[dayIdx - 1];
        this.date = event.getDate();
        this.room = event.getRoom();
        this.person = event.getPerson();

        DateTimeFormatter formatter = DateTimeFormat.forPattern("H:mm");
        LocalTime startTime = event.getStartTime();
        this.startTime = startTime.toString(formatter);
        this.startHour = startTime.getHourOfDay();
        this.startMinute = startTime.getMinuteOfHour();

        LocalTime endTime = event.getEndTime();
        this.endTime = endTime.toString(formatter);
        this.endHour = endTime.getHourOfDay();
        this.endMinute = endTime.getMinuteOfHour();

        this.description = event.getDescription();
    }

    public EventTypeEnum getEventType() {
        return eventType;
    }

    public void setEventType(EventTypeEnum eventType) {
        this.eventType = eventType;
    }

    public ReservationTypeEnum getType() {
        return type;
    }

    public void setType(ReservationTypeEnum type) {
        this.type = type;
    }

    public DayEnum getDay() {
        return day;
    }

    public void setDay(DayEnum day) {
        this.day = day;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getStartMinute() {
        return startMinute;
    }

    public void setStartMinute(int startMinute) {
        this.startMinute = startMinute;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public int getEndMinute() {
        return endMinute;
    }

    public void setEndMinute(int endMinute) {
        this.endMinute = endMinute;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
