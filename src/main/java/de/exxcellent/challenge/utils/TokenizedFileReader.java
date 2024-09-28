package de.exxcellent.challenge.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * FileReader separating output by a given delimiter
 */
public class TokenizedFileReader extends FileReader {
    protected String delimiter;

    /**
     * Creates a new TokenizedFileReader with the given filepath and delimiter
     * @param filepath file to be read
     * @param delimiter String to separate tokens
     * @throws FileNotFoundException if no file at given filepath
     */
    public TokenizedFileReader(String filepath, String delimiter) throws FileNotFoundException {
        super(filepath);
        scanner.useDelimiter(delimiter);
        this.delimiter = delimiter;
    }

    /**
     * Checks if there is another token to read
     * @return true if there is a next token, false otherwise
     */
    public boolean hasNextToken() {
        return scanner.hasNext();
    }

    /**
     * Returns the next token of the file
     * @return the next token separated by the delimiter
     * @throws IOException if there is no next token
     */
    public String nextToken() throws IOException {
        if (scanner.hasNext()) {
            return scanner.next();
        } else {
            throw new IOException("No more tokens");
        }
    }

    /**
     * Checks if there is another line to read
     * @return true if there is another line, false otherwise
     */
    public boolean hasNextLine(){
        return scanner.hasNextLine();
    }

    /**
     * Returns all tokens of the next line
     * @return an ArrayList of Strings of all tokens in this line
     * @throws IOException if there are no more lines
     */
    public ArrayList<String> nextLine() throws IOException {
        ArrayList<String> lineTokens = new ArrayList<>();
        String line;

        if (scanner.hasNextLine()) {
            line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter(delimiter);
            while (lineScanner.hasNext()) {
                lineTokens.add(lineScanner.next());
            }
        } else {
            throw new IOException("No more lines");
        }
        return lineTokens;
    }
}
