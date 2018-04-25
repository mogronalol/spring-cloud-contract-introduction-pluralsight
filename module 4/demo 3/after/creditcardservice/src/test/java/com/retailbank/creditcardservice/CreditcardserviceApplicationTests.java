package com.retailbank.creditcardservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureStubRunner(ids = "com.retailbank:creditcheckservice:+:stubs:8080", workOffline = true)
public class CreditcardserviceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldGrantApplicationWhenCreditScoreIsHigh() throws Exception {
        mockMvc.perform(
                post("/credit-card-applications")
                        .contentType(APPLICATION_JSON)
                        .content("{" +
                                "\"citizenNumber\": 1234," +
                                "\"cardType\": \"GOLD\"" +
                                "}"
                        ))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .json("{" +
                                "\"status\":\"GRANTED\"," +
                                "\"uuid\":\"66ce29f3-ae87-4097-94e8-60b3b10c3855\"" +
                                "}"))
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON));
    }

    @Test
    public void shouldDenyApplicationWhenCreditScoreIsLow() throws Exception {
        mockMvc.perform(
                post("/credit-card-applications")
                        .contentType(APPLICATION_JSON)
                        .content("{" +
                                "\"citizenNumber\": 4444," +
                                "\"cardType\": \"GOLD\"" +
                                "}"
                        ))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .json("{" +
                                "\"status\":\"DENIED\"," +
                                "\"uuid\":\"66ce29f3-ae87-4097-94e8-60b3b10c3855\"" +
                                "}"))
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON));
    }
}
