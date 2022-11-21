package de.bcxp.challenge.country;

import de.bcxp.challenge.util.CustomFileReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountryRepository {

    /**
     * Method to retrieve DayTemperature data from the given filename
     *
     * @param fileName the name of the file to be read from
     * @return the List of countries
     */
    public List<Country> getCountriesFromFile(String fileName) {
        List<Country> countries = new ArrayList<>();
        // read from file
        List<String[]> r = CustomFileReader.readStringArrayFromFile(fileName);
        //iterate over every line
        for (String[] strings : r) {
            List<String> line = Arrays.stream(Arrays.toString(strings)
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
     * @param population the population of the country of type String needs to be converted to double and fix dot to comma
     * @param density    the density of the country of type String needs to be converted to double and fix dot to comma
     * @return the new country object
     */
    private Country mapToCountry(String name, String population, String density) {
        String nameParsed = name.replaceAll("\\[", "")
                .replaceAll("\\s+", "");
        double populationParsed = Double.parseDouble(population.replaceAll("\\s+", "")
                .replaceAll("\\.", ","));
        double densityParsed = Double.parseDouble(density.replaceAll("\\s+", "")
                .replaceAll("\\.", ","));

        return new Country(nameParsed, populationParsed, densityParsed);
    }
}
