package contracts.creditcardservice.messaging

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    label("score_of_high_input_output")
    input {
        messageFrom('credit_score_requests')
        messageBody(
                citizenNumber : 1234,
                uuid : $(c(regex(uuid())), p("e2a8b899-6b62-4010-81f1-9faed24fed2b"))
        )
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