package com.retailbank.creditcheckservice;

import java.util.UUID;

public class CreditCheckResponse {
    private final String uuid = UUID.randomUUID().toString();
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

    public String getUuid() {
        return uuid;
    }

    public enum Score {
        HIGH, LOW
    }
}
