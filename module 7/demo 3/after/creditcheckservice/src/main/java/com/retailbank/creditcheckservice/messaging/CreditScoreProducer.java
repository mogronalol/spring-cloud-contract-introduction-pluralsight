package com.retailbank.creditcheckservice.messaging;

import com.retailbank.creditcheckservice.CreditCheckResponse;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class CreditScoreProducer {

    private final Source source;

    public CreditScoreProducer(Source source) {
        this.source = source;
    }

    public void publishScore(CreditCheckResponse creditCheckResponse) {
        source.output().send(MessageBuilder.withPayload(creditCheckResponse).build());
    }
}
