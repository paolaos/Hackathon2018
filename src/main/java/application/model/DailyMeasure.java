package application.model;


public class DailyMeasure {

  private long id;
  private double value;
  private java.sql.Date dateCreated;
  private long indicatorFk;
  private String workProcessFk;
  private String processMeasureFk;
  private ProcessMeasure processMeasure;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public double getValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
  }


  public java.sql.Date getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(java.sql.Date dateCreated) {
    this.dateCreated = dateCreated;
  }


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

  public ProcessMeasure getProcessMeasure() {
    return processMeasure;
  }

  public void setProcessMeasure(ProcessMeasure processMeasure) {
    this.processMeasure = processMeasure;
  }
}
