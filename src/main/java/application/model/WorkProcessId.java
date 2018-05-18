package application.model;

import java.io.Serializable;

/**
 * Created by alexiaborchgrevink on 5/17/18.
 */
public class WorkProcessId implements Serializable {

    private long indicatorId;
    private String name;

    public long getIndicatorId() {
        return indicatorId;
    }

    public void setIndicatorId(long indicatorId) {
        this.indicatorId = indicatorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
