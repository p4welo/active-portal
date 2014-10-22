package pl.ap.domain;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import pl.ap.domain.common.DataEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by parado on 2014-09-24.
 */
@Entity
@Table(name = "course_unit")
public class CourseUnit extends DataEntity {

    public static final String FIELD_COURSE = "course";

    public static final String FIELD_DATE_TIME = "dateTime";

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id", nullable = false)
    @ForeignKey(name = "course_fk")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Course course;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "date_time", nullable = false)
    @NotNull
    private DateTime dateTime;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
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
