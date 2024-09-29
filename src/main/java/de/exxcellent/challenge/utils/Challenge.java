package de.exxcellent.challenge.utils;

import de.exxcellent.challenge.CSVFileReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Rump class for the weather and football challenges
 */
public abstract class Challenge {
    protected String[][] data;
    protected CSVFileReader reader;

    /**
     * Creates a new challenge from the given filepath with the given number of CSV categories and rows
     * Data from the CSV is extracted automatically
     * @param filepath to the CSV file for this challenge
     * @param numberOfCategories contained in the CSV
     * @param numberOfRows contained in the CSV
     */
    public Challenge(String filepath, int numberOfCategories, int numberOfRows){
        data = new String[numberOfCategories][numberOfRows];

        try {
            reader = new CSVFileReader(filepath);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        try {
            extractCSV();
        } catch (IOException e) {
            System.out.println("CSV extraction error: " + e.getMessage());
        }
    }

    /**
     * extracts data from the CSV file to a String[][] structure
     * @throws IOException if a read attempt fails
     */
    protected void extractCSV() throws IOException {
        int x, y;
        x = 0;
        while (reader.hasNextLine()){
            ArrayList<String> line = reader.nextLine();
            y = 0;
            for (String column : line) {
                data[x][y] = column;
                y++;
            }
            x++;
        }
    }

    /**
     * Calculates absolute distance between two values
     * @param valueA first value
     * @param valueB second value
     * @return distance between values
     */
    protected float calculateSpread(float valueA, float valueB) {
        return Math.abs(valueA - valueB);
    }
}
