package com.challenge.excelia.controllers;

import com.challenge.excelia.Entities.DTO.ChallengeRequestDTO;
import com.challenge.excelia.service.ChallengeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ChangeControllerTest {

    @Autowired
    private ChallengeService service;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    ChallengeRequestDTO requestDTO;

    @BeforeEach
    void init() {
        requestDTO = new ChallengeRequestDTO();
    }

    @Test
    public void validateSortedNumbersWhenInputIsCorrectThenSuccess() throws Exception {
        //Arrange
        requestDTO.setNumberList(List.of(7, 2, 1, 9, 5, 3, 8, 25, 42));
        //Act
        MvcResult response = mockMvc
                .perform(MockMvcRequestBuilders.post("/api/challenge/getSortedNumbers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isOk())
                .andReturn();
        //Assert
        String expected = "{\"sortedNumbers\":[1, 2, 8, 3, 5, 9, 7, 25, 42]}";
        JSONAssert.assertEquals(expected, response.getResponse().getContentAsString(), false);
    }

    @Test
    public void validateSortedNumbersWhenInputIsWrongThenThrow() throws Exception {
        //Arrange
        //Act & Assert
           mockMvc
                .perform(MockMvcRequestBuilders.post("/api/challenge/getSortedNumbers")
                        .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertThat(result.getResolvedException()).isInstanceOf(IllegalArgumentException.class))
                .andExpect(result -> assertThat(Objects.requireNonNull(result.getResolvedException()).getMessage()).isEqualTo("The list cannot be empty"))
                .andReturn();

    }
}
