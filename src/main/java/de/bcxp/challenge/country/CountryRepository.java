package de.bcxp.challenge.country;

import de.bcxp.challenge.util.CustomFileReader;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountryRepository {

    private static final Logger logger = LogManager.getLogger(CountryRepository.class);

    /**
     * Method to retrieve DayTemperature data from the given filename
     *
     * @param fileName the name of the file to be read from
     * @return the List of countries
     */
    public List<Country> getCountriesFromFile(String fileName) {
        List<Country> countries = new ArrayList<>();
        // read from file
        List<String[]> result = CustomFileReader.readStringArrayFromFile(fileName);
        //iterate over every line
        for (String[] stringLine : result) {
            List<String> line = Arrays.stream(Arrays.toString(stringLine)
                            .split(";"))
                    .collect(Collectors.toList());
            countries.add(mapToCountry(line.get(0), line.get(3), line.get(4)));
        }
        return countries;
    }

    /**
     * Convert given string parameters to class attributes
     *
     * @param name       the name of the country of type String need to remove brace and white spaces
     * @param population the population of the country
     * @param density    the density of the country
     * @return the new country object
     */
    private Country mapToCountry(String name, String population, String density) {
        String nameParsed = name.replaceAll("\\[", "")
                .replaceAll("\\s+", "");
        double populationParsed = convertStringToDouble(population);
        double densityParsed = convertStringToDouble(density);

        return new Country(nameParsed, populationParsed, densityParsed);
    }

    /**
     * Added number conversion for special cases like 11.222.333,44 and 11,222,333.44
     *
     * @param value the given string to be converted
     * @return the converted string or log an error
     */
    private double convertStringToDouble(String value) {
        double convertedValue = 0;
        try {
            convertedValue = Double.parseDouble(value.replaceAll("\\s+", "")
                    .replaceAll("]", ""));
        } catch (NumberFormatException e) {
            int numberOfDots = StringUtils.countMatches(value, ".");
            int numberOfCommas = StringUtils.countMatches(value, ",");
            if (numberOfDots > 1 && numberOfCommas > 1) {
                logger.error("Can't convert to double invalid input: " + value);
            }
            if (numberOfDots > 1 && numberOfCommas == 1) {
                convertedValue = Double.parseDouble(value.replaceAll("\\.", "")
                        .replaceAll(",", ".")
                        .replaceAll("\\s+", ""));
            }
            if (numberOfDots == 1 && numberOfCommas > 1) {
                convertedValue = Double.parseDouble(value.replaceAll(",", "")
                        .replaceAll("\\s+", ""));
            }

        }

        return convertedValue;
    }
}
