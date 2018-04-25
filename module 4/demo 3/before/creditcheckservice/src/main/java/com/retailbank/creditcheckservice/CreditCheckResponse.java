package com.retailbank.creditcheckservice;

public class CreditCheckResponse {
    private Score score;

    public CreditCheckResponse(Score score) {
        this.score = score;
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
