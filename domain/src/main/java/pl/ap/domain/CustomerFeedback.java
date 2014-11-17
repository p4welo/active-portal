package pl.ap.domain;

/**
 * Created by parado on 2014-10-24.
 */
public class CustomerFeedback {
    private int rate;

    private String type;

    private String description;

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
