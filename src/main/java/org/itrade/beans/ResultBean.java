package org.itrade.beans;

public class ResultBean {

    private Status status;
    private String message;

    public ResultBean() {
        this.status = Status.OK;
    }

    public ResultBean(Status status, String message) {
        this.status = status;
        this.message = message;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
