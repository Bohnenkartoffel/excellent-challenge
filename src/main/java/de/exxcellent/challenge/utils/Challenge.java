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
        for (int y = 0; y < data[0].length; y++) {
            ArrayList<String> line = reader.nextLine();
            for (int x = 0; x < data.length; x++) {
                data[x][y] = line.get(x);
            }
        }
    }

    /**
     * Finds the row where column A and B have the least spread. A and B values are parsed as float.
     * The result will be the value of outputColumn in the row with the least spread, choosing the first row if multiple
     * rows share the minimal spread.
     * @param outputColumnIndex index of the column to be used as output
     * @param columnIndexA index of column A to be used for the spread search
     * @param columnIndexB index of column B to be used for the spread search
     * @return value of outputColumn at the row with the least spread between float-converted column A and B values
     */
    protected String findLeastSpread(int outputColumnIndex, int columnIndexA, int columnIndexB){
        String[] outputColumn = data[outputColumnIndex];
        String[] columnA = data[columnIndexA];
        String[] columnB = data[columnIndexB];
        float currentMinimalSpread = Float.MAX_VALUE;
        String result = "No result found";

        //Starting from i=1 to avoid category row
        for (int i = 1; i < outputColumn.length; i++){
            float a = Float.parseFloat(columnA[i]);
            float b = Float.parseFloat(columnB[i]);
            float spread = calculateSpread(a, b);
            if (spread < currentMinimalSpread){
                currentMinimalSpread = spread;
                result = outputColumn[i];
            }
        }
        return result;
    }

    /**
     * Runs the challenge and returns the result in String form
     * @return the result of the challenge
     */
    public abstract String run();

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
