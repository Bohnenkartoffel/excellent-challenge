package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example JUnit 5 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
class AppTest {

    @Test
    void runDefault() {
        App.main();
    }

    @Test
    void runWeather() {
        App.main("--weather", "weather.csv");
    }

    @Test
    void runFootball() {
        App.main("--football", "football.csv");
    }

}