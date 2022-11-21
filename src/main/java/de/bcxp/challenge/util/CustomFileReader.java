package de.bcxp.challenge.util;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.List;

public class CustomFileReader {

    /**
     * Reads string data from the given file name
     *
     * @param fileName name of the input file
     * @return a list of strings or Exception in case of error while reading the file
     */
    public static List<String[]> readStringArrayFromFile(String fileName) {
        List<String[]> stringsFromFile;
        try (CSVReader reader = new CSVReader(new java.io.FileReader(fileName))) {
            //check if File is empty
            if (reader.readNext() == null) {
                System.out.println("Input file is empty!");
            }
            stringsFromFile = reader.readAll();
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
        return stringsFromFile;
    }
}
