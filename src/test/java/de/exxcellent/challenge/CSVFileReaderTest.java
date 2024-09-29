package de.exxcellent.challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CSVFileReaderTest {
    private CSVFileReader reader;

    @BeforeEach
    void setUp() {
        try {
            reader = new CSVFileReader("C:\\Users\\linus\\IdeaProjects\\exxcellent-challenge\\programming-challenge\\src\\main\\resources\\de\\exxcellent\\challenge\\weather.csv");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void nextTokenTest() {
        String actualResult;
        try {
            actualResult = reader.nextToken();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String expectedResult = "Day";

        assertEquals(actualResult, expectedResult, "CSVFileReader.nextToken failed");
    }

    //Day,MxT,MnT,AvT,AvDP,1HrP TPcpn,PDir,AvSp,Dir,MxS,SkyC,MxR,Mn,R AvSLP
    @Test
    void nextLineTest() {
        ArrayList<String> actualResult, expectedResult;
        try {
            actualResult = reader.nextLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        expectedResult = new ArrayList<>();
        expectedResult.add("Day");
        expectedResult.add("MxT");
        expectedResult.add("MnT");
        expectedResult.add("AvT");
        expectedResult.add("AvDP");
        expectedResult.add("1HrP TPcpn");
        expectedResult.add("PDir");
        expectedResult.add("AvSp");
        expectedResult.add("Dir");
        expectedResult.add("MxS");
        expectedResult.add("SkyC");
        expectedResult.add("MxR");
        expectedResult.add("Mn");
        expectedResult.add("R AvSLP");

        assertEquals(actualResult, expectedResult, "CSVFileReader.nextLine() failed");
    }
}
