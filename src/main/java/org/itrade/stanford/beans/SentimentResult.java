package org.itrade.stanford.beans;

import org.itrade.beans.Status;

public class SentimentResult {
    private Status status;
    private String message;
    private int sentiment;

    public SentimentResult() {
        this.status = Status.OK;
    }

    public SentimentResult(Status status, String message, int sentiment) {
        this.status = status;
        this.message = message;
        this.sentiment = sentiment;
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

    public int getSentiment() {
        return sentiment;
    }

    public void setSentiment(int sentiment) {
        this.sentiment = sentiment;
    }
}
