package com.challenge.excelia.mappers;

import com.challenge.excelia.Entities.DTO.ChallengeResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ChallengeMapperTest {

    @Autowired
    private ChallengeMapper challengeMapper;

    @Test
    void testMap() {
        //Arrange
        List<Integer> numbersList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //Act
        ChallengeResponseDTO result = this.challengeMapper.map(numbersList);
        //Assert
        assertThat(result).isNotNull();
        assertThat(result.getSortedNumbers()).isEqualTo(numbersList);
    }
}
