package com.retailbank.creditcardservice.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class CreditCheckGateway {

    private final RestTemplate restTemplate;
    private final String creditcheckserviceBaseUrl;

    public CreditCheckGateway(RestTemplate restTemplate,
                                            @Value("${creditcheckservice.baseurl}") String creditcheckserviceBaseUrl) {
        this.restTemplate = restTemplate;
        this.creditcheckserviceBaseUrl = creditcheckserviceBaseUrl;
    }

    public CreditCheckResponse doCreditCheckForCitizen(int citizenNumber) {
        final String uri = UriComponentsBuilder.fromHttpUrl(creditcheckserviceBaseUrl)
                .path("credit-scores")
                .toUriString();

        final CreditCheckRequest request = new CreditCheckRequest(citizenNumber);
        final CreditCheckResponse creditCheckResponse = restTemplate.postForObject(uri, request, CreditCheckResponse.class);

        if (!creditCheckResponse.getUuid().equals(request.getUuid())) {
            throw new RuntimeException("If these don't match something horrible happens");
        }

        return creditCheckResponse;
    }

}
