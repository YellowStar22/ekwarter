package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc()
class EkwateurApplicationTests {
    public final static String URL = "http://localhost:8080";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    void testController() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders
            .get(URL+"/factures/client/EKW00000003?mois=02&annee=2004")) // change this to your actual endpoint
            .andExpect(status().isOk())
            .andReturn().getResponse().getContentAsString();
        Assertions.assertEquals(result, "3440.0");
    }

    @Test
    void testValidationRefenceClient() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(URL+"/factures/client/EKW0003?mois=02&annee=2004")) // change this to your actual endpoint
                .andExpect(status().is5xxServerError());
    }

    @Test
    void testValidationRefenceClientInexistant() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get(URL+"/factures/client/EKW00000005?mois=02&annee=2004")) // change this to your actual endpoint
                .andExpect(status().is5xxServerError());
    }
}
