package application.model;


public class ProcessMeasure {

    private ProcessMeasureId processMeasureId;

    private Double variance;
    private Double tolerance;

    private Indicators indicator;

    public Double getVariance() {
        return variance;
    }

    public void setVariance(Double variance) {
        this.variance = variance;
    }

    public Double getTolerance() {
        return tolerance;
    }

    public void setTolerance(Double tolerance) {
        this.tolerance = tolerance;
    }

    public ProcessMeasureId getProcessMeasureId() {
        return processMeasureId;
    }

    public void setProcessMeasureId(ProcessMeasureId processMeasureId) {
        this.processMeasureId = processMeasureId;
    }

    public Indicators getIndicator() {
        return indicator;
    }

    public void setIndicator(Indicators indicator) {
        this.indicator = indicator;
    }
}
