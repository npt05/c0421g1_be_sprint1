package com.codegym.controller;

import com.codegym.DTO.ScheduleDetailDto;
import com.codegym.DTO.ScheduleDto;
import com.codegym.DTO.StudyDayTimeDto;
import com.codegym.DTO.SubjectDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ScheduleController_UpdateSchedule {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void updateSchedule_name_13() throws Exception {
        ScheduleDetailDto scheduleDetailDto = new ScheduleDetailDto();
        ScheduleDto scheduleDto = new ScheduleDto();
        StudyDayTimeDto studyDayTimeDto = new StudyDayTimeDto();
        SubjectDto subjectDto = new SubjectDto();
        scheduleDto.setScheduleId(null);
        studyDayTimeDto.setStudyDayTimeId(null);
        subjectDto.setSubjectId(null);

        scheduleDetailDto.setSchedule(scheduleDto);
        scheduleDetailDto.setStudyDayTime(studyDayTimeDto);
        scheduleDetailDto.setSubject(subjectDto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/schedules/schedule-update")
                .content(this.objectMapper.writeValueAsString(scheduleDetailDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateSchedule_name_18() throws Exception {
        ScheduleDetailDto scheduleDetailDto = new ScheduleDetailDto();
        ScheduleDto scheduleDto = new ScheduleDto();
        StudyDayTimeDto studyDayTimeDto = new StudyDayTimeDto();
        SubjectDto subjectDto = new SubjectDto();
        scheduleDto.setScheduleId(1);
        studyDayTimeDto.setStudyDayTimeId(1);
        subjectDto.setSubjectId(2);

        scheduleDetailDto.setSchedule(scheduleDto);
        scheduleDetailDto.setStudyDayTime(studyDayTimeDto);
        scheduleDetailDto.setSubject(subjectDto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/schedules/schedule-update")
                .content(this.objectMapper.writeValueAsString(scheduleDetailDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
