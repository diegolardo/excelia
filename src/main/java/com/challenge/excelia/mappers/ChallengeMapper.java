package com.challenge.excelia.mappers;

import com.challenge.excelia.Entities.DTO.ChallengeResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ChallengeMapper {

    public ChallengeResponseDTO map(List<Integer> numberList) {
        ChallengeResponseDTO responseDTO = new ChallengeResponseDTO();
        responseDTO.setSortedNumbers(numberList);
        return responseDTO;
    }
}
