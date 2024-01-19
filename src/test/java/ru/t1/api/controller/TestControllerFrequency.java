package ru.t1.api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TestControllerFrequency {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void calculateCharacterFrequency() throws Exception {
        String line = "aaaaabcccc";
        mockMvc.perform(get("/api/v1/calc").param("line", line))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].character").value("a"))
                .andExpect(jsonPath("$[0].frequency").value(5))
                .andExpect(jsonPath("$[1].character").value("c"))
                .andExpect(jsonPath("$[1].frequency").value(4))
                .andExpect(jsonPath("$[2].character").value("b"))
                .andExpect(jsonPath("$[2].frequency").value(1));
    }
}