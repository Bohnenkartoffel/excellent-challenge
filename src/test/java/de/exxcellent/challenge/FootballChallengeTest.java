package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FootballChallengeTest {
    private FootballChallenge challenge;

    @BeforeEach
    void setUp() {
        challenge = new FootballChallenge("C:\\Users\\linus\\IdeaProjects\\exxcellent-challenge\\programming-challenge\\src\\main\\resources\\de\\exxcellent\\challenge\\football.csv");
    }

    @Test
    void runTest() {
        String expectedResult = "Aston_Villa";
        String actualResult = challenge.run();

        assertEquals(actualResult, expectedResult, "FootballChallenge failed");
    }
}
