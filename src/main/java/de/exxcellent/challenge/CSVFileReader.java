package de.exxcellent.challenge;

import de.exxcellent.challenge.utils.TokenizedFileReader;

import java.io.FileNotFoundException;

public class CSVFileReader extends TokenizedFileReader {

    /**
     * Creates a new CSVFileReader with the given filepath
     *
     * @param filepath  file to be read
     * @throws FileNotFoundException if no file at given filepath
     */
    public CSVFileReader(String filepath) throws FileNotFoundException {
        super(filepath, ",");
    }
}
