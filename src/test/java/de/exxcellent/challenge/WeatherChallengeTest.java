package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherChallengeTest {
    private WeatherChallenge challenge;

    @BeforeEach
    void setUp() {
        challenge = new WeatherChallenge("C:\\Users\\linus\\IdeaProjects\\exxcellent-challenge\\programming-challenge\\src\\main\\resources\\de\\exxcellent\\challenge\\weather.csv");
    }

    @Test
    void runTest() {
        String expectedResult = "14";
        String actualResult = challenge.run();

        assertEquals(actualResult, expectedResult, "WeatherChallenge failed");
    }
}
