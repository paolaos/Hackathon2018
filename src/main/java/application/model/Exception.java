package application.model;


public class Exception {

    private long indicatorFk;
    private String workProcessFk;
    private String processMeasureFk;
    private long exceptionId;
    private java.sql.Date dateCreated;
    private java.sql.Timestamp endTime;
    private String priority;
    private Double tolerance;
    private Double value_kpi;
    private String status;

    private ProcessMeasure processMeasure;

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


    public String getProcessMeasureFk() {
        return processMeasureFk;
    }

    public void setProcessMeasureFk(String processMeasureFk) {
        this.processMeasureFk = processMeasureFk;
    }


    public long getExceptionId() {
        return exceptionId;
    }

    public void setExceptionId(long exceptionId) {
        this.exceptionId = exceptionId;
    }


    public java.sql.Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(java.sql.Date dateCreated) {
        this.dateCreated = dateCreated;
    }


    public java.sql.Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(java.sql.Timestamp endTime) {
        this.endTime = endTime;
    }


    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Double getTolerance() {
        return tolerance;
    }

    public void setTolerance(Double tolerance) {
        this.tolerance = tolerance;
    }

    public Double getValue_kpi() {
        return value_kpi;
    }

    public void setValue_kpi(Double value_kpi) {
        this.value_kpi = value_kpi;
    }

    public ProcessMeasure getProcessMeasure() {
        return processMeasure;
    }

    public void setProcessMeasure(ProcessMeasure processMeasure) {
        this.processMeasure = processMeasure;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

