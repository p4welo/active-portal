package pl.ap.domain;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import pl.ap.domain.annotations.Unique;
import pl.ap.domain.common.IdentifiableEntity;
import pl.ap.domain.enums.CourseLevelEnum;
import pl.ap.domain.enums.DayEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by parado on 18.03.14.
 */
@Entity
@Table(name = "course")
@Unique(fields = Course.FIELD_SID, message = Course.NON_UNIQUE_SID_MESSAGE, insensitive = false)
public class Course extends IdentifiableEntity {
    public static final String FIELD_STYLE = "style";

    public static final String FIELD_INSTRUCTOR = "instructor";

    public static final String FIELD_DAY = "day";

    public static final String FIELD_START_TIME = "startTime";

    public static final String FIELD_END_TIME = "endTime";

    public static final String FIELD_CAN_JOIN = "canJoin";

    public static final String FIELD_CAN_REGISTER = "canRegister";

    public static final String FIELD_IN_PROGRESS = "inProgress";

    public static final String FIELD_LEVEL = "level";

    public static final String FIELD_ROOM = "room";

    public static final String FIELD_COMMENT = "comment";

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "style_id", nullable = false)
    @NotNull
    private CourseStyle style;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "instructor_id", nullable = true)
    private Instructor instructor;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private DayEnum day;

    @Column(name = "start_time", nullable = false)
    @NotNull
    private String startTime;

    @Column(name = "end_time", nullable = false)
    @NotNull
    private String endTime;

    @Column(name = "can_join", nullable = false)
    @NotNull
    private Boolean canJoin = false;

    @Column(name = "can_register", nullable = false)
    @NotNull
    private Boolean canRegister = true;

    @Column(name = "in_progress", nullable = false)
    @NotNull
    private Boolean inProgress = false;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull
    private CourseLevelEnum level;

    @Column
    private String comment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id", nullable = true)
    private Room room;

    @ManyToMany(cascade = {CascadeType.ALL})
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name="course_instructor_relation",
            joinColumns={@JoinColumn(name="course_id")},
            inverseJoinColumns={@JoinColumn(name="instructor_id")})
    private List<Instructor> instructors;

    public Boolean getCanJoin() {
        return canJoin;
    }

    public void setCanJoin(Boolean canJoin) {
        this.canJoin = canJoin;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public Boolean getCanRegister() {
        return canRegister;
    }

    public void setCanRegister(Boolean canRegister) {
        this.canRegister = canRegister;
    }

    public Boolean getInProgress() {
        return inProgress;
    }

    public void setInProgress(Boolean inProgress) {
        this.inProgress = inProgress;
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

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public CourseStyle getStyle() {
        return style;
    }

    public void setStyle(CourseStyle style) {
        this.style = style;
    }

    public DayEnum getDay() {
        return day;
    }

    public void setDay(DayEnum day) {
        this.day = day;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CourseLevelEnum getLevel() {
        return level;
    }

    public void setLevel(CourseLevelEnum level) {
        this.level = level;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
