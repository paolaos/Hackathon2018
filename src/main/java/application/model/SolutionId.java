package application.model;

import java.io.Serializable;

/**
 * Created by alexiaborchgrevink on 5/17/18.
 */
public class SolutionId implements Serializable {

    private long exceptionFk;
    private String id;


    public long getExceptionFk() {
        return exceptionFk;
    }

    public void setExceptionFk(long exceptionFk) {
        this.exceptionFk = exceptionFk;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



}
