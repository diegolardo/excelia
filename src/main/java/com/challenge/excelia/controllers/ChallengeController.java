package com.challenge.excelia.controllers;

import com.challenge.excelia.Entities.DTO.ChallengeRequestDTO;
import com.challenge.excelia.Entities.DTO.ChallengeResponseDTO;
import com.challenge.excelia.mappers.ChallengeMapper;
import com.challenge.excelia.service.ChallengeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Diego de Figueiredo
 * */
@RestController
@RequestMapping("/api/challenge")
public class ChallengeController {

    @Autowired
    private ChallengeService service;

    @Autowired
    private ChallengeMapper mapper;

    @PostMapping(path = "/getSortedNumbers")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ChallengeResponseDTO> getSortedNumbers(@RequestBody ChallengeRequestDTO requestDTO) {
        if(requestDTO.getNumberList() == null || requestDTO.getNumberList().isEmpty()) {
            throw new IllegalArgumentException("The list cannot be empty");
        }
        return ResponseEntity.ok(this.mapper.map(service.getSortedNumbers(requestDTO.getNumberList())));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
