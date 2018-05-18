package application.model;


public class Solution {

  private SolutionId solutionId;

    private long count;
    private String description;
    private Integer rank;

  private Exception exception;

    public SolutionId getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(SolutionId solutionId) {
        this.solutionId = solutionId;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
