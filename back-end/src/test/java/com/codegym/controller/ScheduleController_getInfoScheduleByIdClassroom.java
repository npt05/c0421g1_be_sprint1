package com.codegym.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ScheduleController_getInfoScheduleByIdClassroom {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getInfoStudent_1() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/schedules/schedule-classroom/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getInfoStudent_2() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/schedules/schedule-classroom/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getInfoStudent_3() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/schedules/schedule-classroom/{id}", "15"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getInfoStudent_4() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get(
                        "/api/schedules/schedule-classroom/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
