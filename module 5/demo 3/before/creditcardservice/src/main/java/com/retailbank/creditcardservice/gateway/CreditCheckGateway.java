package com.retailbank.creditcardservice.gateway;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class CreditCheckGateway {

    private final RestTemplate restTemplate;

    public CreditCheckGateway(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CreditCheckResponse.Score doCreditCheckForCitizen(int citizenNumber) {
        final String uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080")
                .path("credit-scores")
                .toUriString();

        return restTemplate.postForObject(uri, new CreditCheckRequest(citizenNumber), CreditCheckResponse.class).getScore();
    }

}
