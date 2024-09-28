package de.exxcellent.challenge.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Allows reading of a file
 */
public abstract class FileReader {
    protected String filepath;
    protected File file;
    protected Scanner scanner;

    /**
     * Reads the file at the given filepath
     * @param filepath of the file
     * @throws FileNotFoundException if file does not exist at the given filepath
     */
    FileReader(String filepath) throws FileNotFoundException {
        this.filepath = filepath;
        this.file = new File(filepath);
        scanner = new Scanner(file);
    }
}
