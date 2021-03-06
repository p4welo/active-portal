package pl.ap.domain;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.joda.time.DateTime;
import pl.ap.domain.annotations.Unique;
import pl.ap.domain.common.IdentifiableEntity;
import pl.ap.domain.enums.TicketTypeEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by parado on 2015-01-14.
 */
@Entity
@Table(name = "ticket")
@Unique(fields = Ticket.FIELD_SID, message = Ticket.NON_UNIQUE_SID_MESSAGE, insensitive = false)
public class Ticket extends IdentifiableEntity {

    public static final String FIELD_PURCHASE_DATE = "purchaseDate";

    public static final String FIELD_TYPE = "type";

    public static final String FIELD_ENTRANCES_USED = "entrancesUsed";

    public static final String FIELD_COURSE_SID = "courseSid";

    public static final String FIELD_STYLE_NAME = "styleName";

    public static final String FIELD_CUSTOMER = "customer";

    public static final String FIELD_BARCODE = "barcode";

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @Column(name = "purchase_date", nullable = false)
    @NotNull
    private DateTime purchaseDate;

    @Column(name = "entrances_used", nullable = false)
    @NotNull
    private int entrancesUsed;

    @Column(name = "course_sid", length = IdentifiableEntity.MAX_LENGTH_SID)
    @Length(max = IdentifiableEntity.MAX_LENGTH_SID)
    private String courseSid;

    @Column(name = "style_name")
    private String styleName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = false)
    @ForeignKey(name = "customer_fk")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id", nullable = false)
    @ForeignKey(name = "type_fk")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @NotNull
    private TicketType type;

    @Column(length = 64, nullable = false)
    @NotBlank
    private String barcode;

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public DateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(DateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getEntrancesUsed() {
        return entrancesUsed;
    }

    public void setEntrancesUsed(int entrancesUsed) {
        this.entrancesUsed = entrancesUsed;
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

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @Override
    public String toString() {
        return getType().getName() + " - " + getBarcode() + " " + getEntrancesUsed() + "/" + getType().getEntrancePool();
    }
}