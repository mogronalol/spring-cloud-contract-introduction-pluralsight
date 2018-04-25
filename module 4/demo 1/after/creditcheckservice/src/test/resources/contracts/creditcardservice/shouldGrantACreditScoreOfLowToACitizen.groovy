package contracts.creditcardservice

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url '/credit-scores'
        body """
        {
            "citizenNumber" : 4444
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
            "score" : "LOW" 
        }
        """
        headers {
            contentType applicationJson()
        }
    }
}