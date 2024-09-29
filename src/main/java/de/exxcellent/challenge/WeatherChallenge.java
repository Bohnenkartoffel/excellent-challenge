package de.exxcellent.challenge;

import de.exxcellent.challenge.utils.Challenge;

public class WeatherChallenge extends Challenge {

    /**
     * Creates a new Weather Challenge with the given data
     *
     * @param filepath to the CSV data
     */
    public WeatherChallenge(String filepath) {
        super(filepath, 14, 31);
    }

    /**
     * finds the least spread between MxT, MnT columns of weather.csv and returns the corresponding Day column value
     * @return Day with the least spread between MxT and MnT
     */
    @Override
    public String run() {
        return findLeastSpread(0, 1, 2);
    }
}
