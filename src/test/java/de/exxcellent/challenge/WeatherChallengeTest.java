package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherChallengeTest {
    private WeatherChallenge challenge;

    @BeforeEach
    void setUp() {
        String resourcesDirectory = System.getProperty("user.dir") + "\\src\\main\\resources\\de\\exxcellent\\challenge\\";
        challenge = new WeatherChallenge(resourcesDirectory + "weather.csv");
    }

    @Test
    void runTest() {
        String expectedResult = "14";
        String actualResult = challenge.run();

        assertEquals(actualResult, expectedResult, "WeatherChallenge failed");
    }
}
