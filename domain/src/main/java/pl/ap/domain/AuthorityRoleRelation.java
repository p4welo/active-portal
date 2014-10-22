package pl.ap.domain;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import pl.ap.domain.common.DataEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by parado on 2014-10-16.
 */
@Entity
@Table(name = "authority_role_relation")
public class AuthorityRoleRelation extends DataEntity {

    public static final String FIELD_AUTHORITY = "authority";

    public static final String FIELD_ROLE = "role";

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "authority_id", nullable = false)
    @ForeignKey(name = "authority_fk")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Authority authority;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    @ForeignKey(name = "role_fk")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Role role;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
