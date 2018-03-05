package pl.ap.domain;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import pl.ap.domain.common.DataEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by parado on 2015-02-05.
 */
@Entity
@Table(name = "course_instructor_relation")
public class CourseInstructorRelation extends DataEntity {

    public static final String FIELD_INSTRUCTOR = "instructor";

    public static final String FIELD_COURSE = "course";

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "instructor_id", nullable = false)
    @ForeignKey(name = "instructor_fk")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Instructor instructor;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
