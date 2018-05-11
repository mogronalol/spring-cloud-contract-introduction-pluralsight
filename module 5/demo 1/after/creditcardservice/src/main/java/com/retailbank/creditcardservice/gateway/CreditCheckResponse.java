package com.retailbank.creditcardservice.gateway;

public class CreditCheckResponse {
    private Score score;

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public enum Score {
        HIGH
    }
}
