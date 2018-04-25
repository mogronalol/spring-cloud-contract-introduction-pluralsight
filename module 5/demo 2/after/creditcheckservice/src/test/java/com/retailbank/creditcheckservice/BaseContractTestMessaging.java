package com.retailbank.creditcheckservice;

import com.retailbank.creditcheckservice.messaging.CreditScoreProducer;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.retailbank.creditcheckservice.CreditCheckResponse.Score.HIGH;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CreditcheckserviceApplication.class)
@AutoConfigureMessageVerifier
public class BaseContractTestMessaging {

    @Autowired
    private CreditScoreProducer creditScoreProducer;

    public void scoreOfHigh() {

        final String uuid = "e2a8b899-6b62-4010-81f1-9faed24fed2b";

        creditScoreProducer.publishScore(new CreditCheckResponse(uuid, HIGH));
    }
}
