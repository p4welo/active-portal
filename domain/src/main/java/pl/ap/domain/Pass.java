package pl.ap.domain;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.joda.time.DateTime;
import pl.ap.domain.annotations.Unique;
import pl.ap.domain.common.IdentifiableEntity;
import pl.ap.domain.enums.PassTypeEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by parado on 2015-01-14.
 */
@Entity
@Table(name = "pass")
@Unique(fields = Pass.FIELD_SID, message = Pass.NON_UNIQUE_SID_MESSAGE, insensitive = false)
public class Pass extends IdentifiableEntity {

    public static final String FIELD_PURCHASE_DATE = "purchaseDate";

    public static final String FIELD_TYPE = "type";

    public static final String FIELD_ENTRANCES_USED = "entrancesUsed";

    public static final String FIELD_ENTRANCE_POOL = "entrancePool";

    public static final String FIELD_COURSE_SID = "courseSid";

    public static final String FIELD_STYLE_NAME = "styleName";

    public static final String FIELD_CUSTOMER = "customer";

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "purchase_date", nullable = false)
    @NotNull
    private DateTime purchaseDate;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private PassTypeEnum type;

    @Column(name = "entrances_used", nullable = false)
    @NotNull
    private int entrancesUsed;

    @Column(name = "entrance_pool", nullable = false)
    @NotNull
    private int entrancePool;

    @Column(name = "course_sid", length = IdentifiableEntity.MAX_LENGTH_SID)
    @Length(max = IdentifiableEntity.MAX_LENGTH_SID)
    private String courseSid;

    @Column(name = "style_name")
    private String styleName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    @ForeignKey(name = "customer_fk")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Customer customer;

    public DateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(DateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public PassTypeEnum getType() {
        return type;
    }

    public void setType(PassTypeEnum type) {
        this.type = type;
    }

    public int getEntrancesUsed() {
        return entrancesUsed;
    }

    public void setEntrancesUsed(int entrancesUsed) {
        this.entrancesUsed = entrancesUsed;
    }

    public int getEntrancePool() {
        return entrancePool;
    }

    public void setEntrancePool(int entrancePool) {
        this.entrancePool = entrancePool;
    }

    public String getCourseSid() {
        return courseSid;
    }

    public void setCourseSid(String courseSid) {
        this.courseSid = courseSid;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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