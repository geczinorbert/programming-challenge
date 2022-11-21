package de.bcxp.challenge.weather;

import de.bcxp.challenge.util.CustomFileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class DayTemperatureRepository {

    /**
     * Method to retrieve DayTemperature data from the given filename
     *
     * @param fileName the name of the file to be read from
     * @return the List of DayTemperature
     */
    public List<DayTemperature> getDayTemperaturesFromFile(String fileName) {
        List<DayTemperature> dayTemperatures = new ArrayList<>();
        // read from file
        List<String[]> result = CustomFileReader.readStringArrayFromFile(fileName);
        //iterate over every line
        for (String[] stringLine : result) {
            List<String> line = Arrays.stream(Arrays.toString(stringLine)
                            .split(","))
                    .collect(Collectors.toList());
            dayTemperatures.add(mapToDayTemperature(line.get(0), line.get(1), line.get(2)));
        }
        return dayTemperatures;
    }

    /**
     * Convert parameter data into DayTemperature object
     *
     * @param dayOfTheMonth the day of the month in String format need to remove array clause and whitespaces
     * @param maxTemp       the maximum Temperature of the day in String format need to remove whitespaces
     * @param minTemp       the minimum Temperature of the day in String format need array clause and to remove whitespaces
     * @return the new DayTemperature object
     */
    private DayTemperature mapToDayTemperature(String dayOfTheMonth, String maxTemp, String minTemp) {
        int dayOfTheMonthParsed = Integer.parseInt(dayOfTheMonth.replaceAll("\\[", "")
                .replaceAll("\\s+", ""));
        int maxTempParsed = Integer.parseInt(maxTemp.replaceAll("\\s+", ""));
        int minTempParsed = Integer.parseInt(minTemp.replaceAll("\\s+", "")
                .replaceAll("]", ""));
        return new DayTemperature(dayOfTheMonthParsed, maxTempParsed, minTempParsed);
    }
}
