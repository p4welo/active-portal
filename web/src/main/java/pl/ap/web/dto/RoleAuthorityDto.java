package pl.ap.web.dto;

import pl.ap.domain.Authority;

/**
 * Created by parado on 2014-10-22.
 */
public class RoleAuthorityDto {
    private Authority authority;

    private boolean checked;

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
