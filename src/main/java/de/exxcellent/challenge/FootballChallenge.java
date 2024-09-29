package de.exxcellent.challenge;

import de.exxcellent.challenge.utils.Challenge;

public class FootballChallenge extends Challenge {

    /**
     * Creates a new challenge from the given filepath with the given number of CSV categories and rows
     * Data from the CSV is extracted automatically
     *
     * @param filepath           to the CSV file for this challenge
     */
    public FootballChallenge(String filepath) {
        super(filepath, 8, 21);
    }

    @Override
    public String run() {
        return findLeastSpread(0, 5, 6);
    }
}
