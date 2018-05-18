package application.model;

import java.io.Serializable;

/**
 * Created by alexiaborchgrevink on 5/17/18.
 */
public class FinalSolutionId implements Serializable {

    private long exceptionFk;
    private String solutionFk;


    public long getExceptionFk() {
        return exceptionFk;
    }

    public void setExceptionFk(long exceptionFk) {
        this.exceptionFk = exceptionFk;
    }


    public String getSolutionFk() {
        return solutionFk;
    }

    public void setSolutionFk(String solutionFk) {
        this.solutionFk = solutionFk;
    }
}
