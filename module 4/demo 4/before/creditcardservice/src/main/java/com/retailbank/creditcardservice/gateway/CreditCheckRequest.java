package com.retailbank.creditcardservice.gateway;

import java.time.LocalDate;

public class CreditCheckRequest {
    private final int citizenNumber;
    private final String requestedDate = LocalDate.now().toString();

    public CreditCheckRequest(int citizenNumber) {
        this.citizenNumber = citizenNumber;
    }

    public int getCitizenNumber() {
        return citizenNumber;
    }

    public String getRequestedDate() {
        return requestedDate;
    }
}
