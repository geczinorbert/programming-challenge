package de.bcxp.challenge.weather;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DayTemperatureRepository {

    public List<DayTemperature> getDayTemperaturesFromFile(String fileName) {
        List<DayTemperature> dayTemperatures = new ArrayList<>();
        // read from file
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            if (reader.readNext() == null) {
                System.out.println("Input file is empty!");

            }
            List<String[]> r = reader.readAll();
            //check if File is empty
            r.forEach(System.out::println);

        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
        return dayTemperatures;
    }
}
