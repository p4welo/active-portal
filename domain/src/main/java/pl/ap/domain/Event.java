package pl.ap.domain;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import pl.ap.domain.annotations.Unique;
import pl.ap.domain.common.IdentifiableEntity;
import pl.ap.domain.enums.EventTypeEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by parado on 2015-05-07.
 */
@Entity
@Table(name = "event")
@Unique(fields = Event.FIELD_SID, message = Event.NON_UNIQUE_SID_MESSAGE, insensitive = false)
public class Event extends IdentifiableEntity {

    public static final String FIELD_DATE = "date";

    public static final String FIELD_START_TIME = "startTime";

    public static final String FIELD_END_TIME = "endTime";

    public static final String FIELD_TYPE = "type";

    public static final String FIELD_PERSON = "person";

    public static final String FIELD_CREATED_AT = "createdAt";

    public static final String FIELD_CREATED_BY = "createdBy";

    public static final String FIELD_DESCRIPTION = "description";

    public static final String FIELD_ROOM = "room";

    public static final int PERSON_MAX_LENGTH = 128;

    public static final int DESCRIPTION_MAX_LENGTH = 255;

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @Column(nullable = false)
    @NotNull
    private LocalDate date;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalTime")
    @Column(name = "start_time", nullable = false)
    @NotNull
    private LocalTime startTime;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalTime")
    @Column(name = "end_time", nullable = false)
    @NotNull
    private LocalTime endTime;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private EventTypeEnum type;

    @Column(nullable = false, length = PERSON_MAX_LENGTH)
    @NotBlank
    @Length(max = PERSON_MAX_LENGTH)
    private String person;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "created_at", nullable = false)
    @NotNull
    private DateTime createdAt;

    @Column(name = "created_by", nullable = false)
    @NotBlank
    private String createdBy;

    @Column(length = DESCRIPTION_MAX_LENGTH)
    @Length(max = DESCRIPTION_MAX_LENGTH)
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id", nullable = false)
    @NotNull
    private Room room;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
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

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
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

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
