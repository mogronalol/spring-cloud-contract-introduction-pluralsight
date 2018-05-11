package contracts.creditcardservice.messaging

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    label("score_of_high")
    input {
        triggeredBy('scoreOfHigh()')
    }
    outputMessage {
        sentTo("credit_scores")
        body(
            score : "HIGH",
            uuid : "e2a8b899-6b62-4010-81f1-9faed24fed2b"
        )
        headers {
            header("contentType", applicationJsonUtf8())
        }
    }
}