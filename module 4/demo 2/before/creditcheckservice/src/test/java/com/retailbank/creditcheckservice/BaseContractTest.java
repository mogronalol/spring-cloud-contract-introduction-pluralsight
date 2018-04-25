package com.retailbank.creditcheckservice;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

import static com.retailbank.creditcheckservice.CreditCheckResponse.Score.HIGH;
import static com.retailbank.creditcheckservice.CreditCheckResponse.Score.LOW;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BaseContractTest {

    @Before
    public void setUp() {
        final CreditCheckService mock = mock(CreditCheckService.class);
        when(mock.doCreditCheck(1234)).thenReturn(new CreditCheckResponse(HIGH));
        when(mock.doCreditCheck(4444)).thenReturn(new CreditCheckResponse(LOW));
        RestAssuredMockMvc.standaloneSetup(new CreditCheckController(mock));
    }
}
