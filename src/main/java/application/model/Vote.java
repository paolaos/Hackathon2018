package application.model;


public class Vote {

  private String userFk;
  private String solutionFk;
  private long exceptionFk;
  private java.sql.Timestamp voteTime;


  public String getUserFk() {
    return userFk;
  }

  public void setUserFk(String userFk) {
    this.userFk = userFk;
  }


  public String getSolutionFk() {
    return solutionFk;
  }

  public void setSolutionFk(String solutionFk) {
    this.solutionFk = solutionFk;
  }


  public long getExceptionFk() {
    return exceptionFk;
  }

  public void setExceptionFk(long exceptionFk) {
    this.exceptionFk = exceptionFk;
  }


  public java.sql.Timestamp getVoteTime() {
    return voteTime;
  }

  public void setVoteTime(java.sql.Timestamp voteTime) {
    this.voteTime = voteTime;
  }

}
