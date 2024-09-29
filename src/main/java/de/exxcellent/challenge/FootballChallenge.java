package de.exxcellent.challenge;

import de.exxcellent.challenge.utils.Challenge;

public class FootballChallenge extends Challenge {

    /**
     * Creates a new Football Challenge from the given CSV file
     * Data from the CSV is extracted automatically
     *
     * @param filepath           to the CSV file for this challenge
     */
    public FootballChallenge(String filepath) {
        super(filepath, 8, 21);
    }

    /**
     * Finds the team with the least difference between goals and goals allowed
     * @return name of the team with the least difference between goals and goals allowed
     */
    @Override
    public String run() {
        return findLeastSpread(0, 5, 6);
    }
}
