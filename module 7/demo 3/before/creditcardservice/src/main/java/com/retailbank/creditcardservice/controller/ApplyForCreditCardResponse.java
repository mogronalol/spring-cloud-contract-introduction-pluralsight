package com.retailbank.creditcardservice.controller;

public class ApplyForCreditCardResponse {
    private final Status status;
    private final String uuid;

    public ApplyForCreditCardResponse(Status status, String uuid) {

        this.status = status;
        this.uuid = uuid;
    }

    public Status getStatus() {
        return status;
    }

    public String getUuid() {
        return uuid;
    }

    public enum Status {
        DENIED, GRANTED
    }
}
