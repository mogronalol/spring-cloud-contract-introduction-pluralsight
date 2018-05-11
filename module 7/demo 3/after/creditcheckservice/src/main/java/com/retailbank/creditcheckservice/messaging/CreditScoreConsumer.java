package com.retailbank.creditcheckservice.messaging;

import com.retailbank.creditcheckservice.CreditCheckRequest;
import com.retailbank.creditcheckservice.CreditCheckResponse;
import com.retailbank.creditcheckservice.CreditCheckService;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
public class CreditScoreConsumer {

    private final CreditCheckService creditCheckService;
    private final CreditScoreProducer creditScoreProducer;

    public CreditScoreConsumer(CreditCheckService creditCheckService,
                               CreditScoreProducer creditScoreProducer) {
        this.creditCheckService = creditCheckService;
        this.creditScoreProducer = creditScoreProducer;
    }

    @StreamListener(Sink.INPUT)
    public void consume(CreditCheckRequest creditCheckRequest) {
        final CreditCheckResponse creditCheckResponse = creditCheckService.doCreditCheck(creditCheckRequest.getCitizenNumber());
        creditScoreProducer.publishScore(creditCheckResponse);
    }
}
