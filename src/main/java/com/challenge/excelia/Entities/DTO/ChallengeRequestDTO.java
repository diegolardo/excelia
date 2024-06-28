package com.challenge.excelia.Entities.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class ChallengeRequestDTO implements Serializable {

    @NotNull(message = "The numberList param cannot be null")
    private List<Integer> numberList;

}
