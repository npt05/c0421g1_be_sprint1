package com.codegym.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ScheduleController_getListGrade {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getListGrade_05() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/schedules/grades", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getListGrade_06() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/schedules/grades", ""))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
