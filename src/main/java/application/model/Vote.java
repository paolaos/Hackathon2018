package application.model;


public class Vote {

  private VoteId voteId;

  private java.sql.Timestamp voteTime;

    public VoteId getVoteId() {
        return voteId;
    }

    public void setVoteId(VoteId voteId) {
        this.voteId = voteId;
    }

    public java.sql.Timestamp getVoteTime() {
    return voteTime;
  }

  public void setVoteTime(java.sql.Timestamp voteTime) {
    this.voteTime = voteTime;
  }

}
