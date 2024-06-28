package com.challenge.excelia.Entities.DTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
public class ChallengeResponseDTO {

   @NonNull
   private List<Integer> sortedNumbers;

}