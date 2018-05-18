package application.model;

import java.io.Serializable;

/**
 * Created by alexiaborchgrevink on 5/17/18.
 */
public class ProcessMeasureId implements Serializable {

    private long indicatorFk;
    private String workProcessFk;
    private String name;


    public long getIndicatorFk() {
        return indicatorFk;
    }

    public void setIndicatorFk(long indicatorFk) {
        this.indicatorFk = indicatorFk;
    }


    public String getWorkProcessFk() {
        return workProcessFk;
    }

    public void setWorkProcessFk(String workProcessFk) {
        this.workProcessFk = workProcessFk;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
