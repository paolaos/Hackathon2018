package application.model;

/**
 * Created by alexiaborchgrevink on 5/17/18.
 */
public class ProcessMeasureId {

    private long indicatorFk;
    private String workProcessFk;
    private String name;
    private double variance;
    private double tolerance;


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


    public double getVariance() {
        return variance;
    }

    public void setVariance(double variance) {
        this.variance = variance;
    }


    public double getTolerance() {
        return tolerance;
    }

    public void setTolerance(double tolerance) {
        this.tolerance = tolerance;
    }
}
