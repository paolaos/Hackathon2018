package application.model;


public class Solution {

  private SolutionId solutionId;

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
}
