package com.challenge.excelia.service;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

/**
 * This represents the service class for the challenge.
 * */

@Service
public class ChallengeService {

    public List<Integer> getSortedNumbers(final List<Integer> numbersList) {
        return this.sortList(numbersList);
    }

    private List<Integer> sortList(final List<Integer> numbersList) {
        return numbersList.stream().sorted(Comparator.comparingInt(Integer::bitCount)
                .thenComparingInt(Integer::intValue)).toList();
    }
}
