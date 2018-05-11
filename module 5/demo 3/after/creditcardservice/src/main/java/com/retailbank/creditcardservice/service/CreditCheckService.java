package com.retailbank.creditcardservice.service;

import com.retailbank.creditcardservice.controller.ApplyForCreditCardRequest;
import com.retailbank.creditcardservice.controller.ApplyForCreditCardResponse;
import com.retailbank.creditcardservice.gateway.CreditCheckGateway;
import com.retailbank.creditcardservice.gateway.CreditCheckResponse;
import org.springframework.stereotype.Component;

@Component
public class CreditCheckService {

    private final CreditCheckGateway creditCheckGateway;

    public CreditCheckService(CreditCheckGateway creditCheckGateway) {
        this.creditCheckGateway = creditCheckGateway;
    }

    public ApplyForCreditCardResponse doCheckForCitizen(ApplyForCreditCardRequest applyForCreditCardRequest) {

        final CreditCheckResponse.Score score = creditCheckGateway.doCreditCheckForCitizen(applyForCreditCardRequest.getCitizenNumber());

        if (score == CreditCheckResponse.Score.HIGH && applyForCreditCardRequest.getCardType() == ApplyForCreditCardRequest.CardType.GOLD) {
            return new ApplyForCreditCardResponse(ApplyForCreditCardResponse.Status.GRANTED);
        }
        throw new RuntimeException("Card and score not yet implemented");
    }
}
