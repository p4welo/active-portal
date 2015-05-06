package pl.ap.web.dto;

import pl.ap.domain.Instructor;

import java.util.List;

/**
 * Created by parado on 2015-05-06.
 */
public class SidListDto {

    private List<String> sids;

    public List<String> getSids() {
        return sids;
    }

    public void setSids(List<String> sids) {
        this.sids = sids;
    }
}
