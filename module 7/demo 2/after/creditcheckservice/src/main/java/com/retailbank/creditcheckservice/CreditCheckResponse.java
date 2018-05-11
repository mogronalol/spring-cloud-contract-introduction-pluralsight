package com.retailbank.creditcheckservice;

public class CreditCheckResponse {
    private String uuid;
    private Score score;

    public CreditCheckResponse(String uuid, Score score) {
        this.uuid = uuid;
        this.score = score;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public enum Score {
        HIGH, LOW
    }
}
