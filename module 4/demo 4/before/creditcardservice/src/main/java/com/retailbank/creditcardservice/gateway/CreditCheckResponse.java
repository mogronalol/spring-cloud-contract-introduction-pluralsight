package com.retailbank.creditcardservice.gateway;

public class CreditCheckResponse {
    private Score score;
    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public enum Score {
        HIGH, LOW
    }
}
