package application.model;

public class VoteId {

    private String userFk;
    private String solutionFk;
    private long exceptionFk;

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
}
