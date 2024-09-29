package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FootballChallengeTest {
    private FootballChallenge challenge;

    @BeforeEach
    void setUp() {
        String resourcesDirectory = System.getProperty("user.dir") + "\\src\\main\\resources\\de\\exxcellent\\challenge\\";
        challenge = new FootballChallenge(resourcesDirectory + "football.csv");
    }

    @Test
    void runTest() {
        String expectedResult = "Aston_Villa";
        String actualResult = challenge.run();

        assertEquals(actualResult, expectedResult, "FootballChallenge failed");
    }
}
