package pl.ap.domain;

import org.joda.time.DateTime;
import pl.ap.domain.annotations.Unique;
import pl.ap.domain.common.IdentifiableEntity;
import pl.ap.domain.enums.PeriodTypeEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by parado on 2015-02-28.
 */
@Entity
@Table(name = "ticket_type")
@Unique(fields = TicketTypeGroup.FIELD_SID, message = TicketTypeGroup.NON_UNIQUE_SID_MESSAGE, insensitive = false)
public class TicketType extends IdentifiableEntity {

    public static final String FIELD_PRICE = "price";

    public static final String FIELD_ENTRANCE_POOL = "entrancePool";

    public static final String FIELD_PERIOD_TYPE = "periodType";

    public static final String FIELD_PERIOD_AMOUNT = "periodAmount";

    public static final String FIELD_GROUP = "group";

    @Id
    @GeneratedValue
    private Long id;

    @Column
    @NotNull
    private BigDecimal price;

    @Column(name = "entrance_pool", nullable = false)
    @NotNull
    private int entrancePool;

    @Column(name = "period_type", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    @NotNull
    private PeriodTypeEnum periodType;

    @Column(name = "period_amount", nullable = false)
    @NotNull
    private int periodAmount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id", nullable = false)
    @NotNull
    private TicketTypeGroup group;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public PeriodTypeEnum getPeriodType() {
        return periodType;
    }

    public void setPeriodType(PeriodTypeEnum periodType) {
        this.periodType = periodType;
    }

    public int getPeriodAmount() {
        return periodAmount;
    }

    public void setPeriodAmount(int periodAmount) {
        this.periodAmount = periodAmount;
    }

    public int getEntrancePool() {
        return entrancePool;
    }

    public void setEntrancePool(int entrancePool) {
        this.entrancePool = entrancePool;
    }

    public TicketTypeGroup getGroup() {
        return group;
    }

    public void setGroup(TicketTypeGroup group) {
        this.group = group;
    }
}
