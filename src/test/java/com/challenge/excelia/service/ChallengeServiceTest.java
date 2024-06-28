package com.challenge.excelia.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ChallengeServiceTest {

    @InjectMocks
    private ChallengeService challengeService;

    @Test
    void testGetSortedNumbers() {
        // Arrange
        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(4);
        numberList.add(5);
        numberList.add(6);
        numberList.add(7);
        numberList.add(8);
        numberList.add(9);
        numberList.add(10);
        // Act
        List<Integer> actualGetSortedNumbersResult = challengeService.getSortedNumbers(numberList);
        // Assert
        assertEquals(Arrays.asList(1, 2, 4, 8, 3, 5, 6, 9, 10, 7), actualGetSortedNumbersResult);
    }
}
