package application.model;


public class ProcessMeasure {

    private ProcessMeasureId processMeasureId;

    private Indicators indicator;

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
