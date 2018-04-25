package contracts.creditcardservice.http

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/credit-scores'
        body (
            "citizenNumber" : 1234,
            "requestedDate" : $(consumer(anyDate()), producer("2017-07-07")),
            "uuid" : $(consumer(anyUuid()), producer("66ce29f3-ae87-4097-94e8-60b3b10c3855"))
        )
        headers {
            contentType applicationJson()
        }
    }
    response {
        status 200
        body (
            "score" : "HIGH",
            "uuid" : $(consumer(fromRequest().body('$.uuid')), producer("66ce29f3-ae87-4097-94e8-60b3b10c3855"))
        )
        headers {
            contentType applicationJson()
        }
    }
}