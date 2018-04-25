package com.retailbank.creditcardservice.listener;

import com.retailbank.creditcardservice.gateway.CreditCheckResponse;
import com.retailbank.creditcardservice.repository.CreditScoreRepository;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
public class CreditScoreListener {

    private final CreditScoreRepository creditScoreRepository;

    public CreditScoreListener(CreditScoreRepository creditScoreRepository) {
        this.creditScoreRepository = creditScoreRepository;
    }

    @StreamListener(Sink.INPUT)
    public void receiveScore(CreditCheckResponse creditCheckResponse) {
        creditScoreRepository.save(creditCheckResponse.getUuid(), creditCheckResponse.getScore());
    }
}
