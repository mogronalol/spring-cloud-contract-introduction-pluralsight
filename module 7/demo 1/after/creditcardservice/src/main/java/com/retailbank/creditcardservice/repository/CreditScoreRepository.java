package com.retailbank.creditcardservice.repository;

import com.retailbank.creditcardservice.gateway.CreditCheckResponse;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class CreditScoreRepository {

    private final Map<String, CreditCheckResponse.Score> creditScores = new HashMap<>();

    public CreditCheckResponse.Score getScore(UUID uuid) {
        return creditScores.get(uuid.toString());
    }

    public void save(String uuid, CreditCheckResponse.Score score) {
        creditScores.put(uuid, score);
    }
}
