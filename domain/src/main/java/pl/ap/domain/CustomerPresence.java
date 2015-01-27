package pl.ap.domain;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import pl.ap.domain.common.DataEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by parado on 2014-09-24.
 */
@Entity
@Table(name = "customer_presence")
public class CustomerPresence extends DataEntity {

    public static final String FIELD_CUSTOMER = "customer";

    public static final String FIELD_LESSON = "lesson";

    public static final String FIELD_PRESENT = "present";

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    @ForeignKey(name = "customer_fk")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id", nullable = false)
    @ForeignKey(name = "lesson_fk")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private CourseLesson lesson;

    @Column
    @NotNull
    private boolean present;

//    private String passSid;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CourseLesson getLesson() {
        return lesson;
    }

    public void setLesson(CourseLesson lesson) {
        this.lesson = lesson;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
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
