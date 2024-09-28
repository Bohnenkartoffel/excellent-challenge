package de.exxcellent.challenge.utils;

import de.exxcellent.challenge.CSVFileReader;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Rump class for the weather and football challenges
 */
public abstract class Challenge {
    CategorizedColumns columns;
    protected CSVFileReader reader;

    /**
     * Creates a new Challenge with the given data
     * @param filepath to the CSV data
     */
    public Challenge(String filepath){
        try {
            reader = new CSVFileReader(filepath);
            extractCSVToCategorizedColumns();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * extracts data from the CSV file to a CategorizedColumns structure
     * @throws IOException if there is an error reading from the CSV
     */
    protected void extractCSVToCategorizedColumns() throws Exception {
        CategorizedColumns columns = new CategorizedColumns();
        if (reader.hasNextLine()){
            ArrayList<String> categories = reader.nextLine();
            columns = extractColumnValues(categories);
        }
        this.columns = columns;
    }

    /**
     * retrieves values for each category of the CSV.
     * Assumes that the first line containing the categories has already been read
     * @param categories under which the values are to be stored
     * @return CategorizedColumns with the given categories and read values
     */
    protected abstract CategorizedColumns extractColumnValues(ArrayList<String> categories) throws Exception;
}
