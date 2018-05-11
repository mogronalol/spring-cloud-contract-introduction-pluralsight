package contracts.creditcardservice

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/credit-scores'
        body """
        {
            "citizenNumber" : 1234
        }
        """
        headers {
            contentType applicationJson()
        }
    }
    response {
        status 200
        body """
        {
            "score" : "HIGH" 
        }
        """
        headers {
            contentType applicationJson()
        }
    }
}