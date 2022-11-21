package de.bcxp.challenge;

import de.bcxp.challenge.country.CountryRepository;
import de.bcxp.challenge.country.CountryService;
import de.bcxp.challenge.weather.DayTemperatureRepository;
import de.bcxp.challenge.weather.DayTemperatureService;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …
        String fileNameWeather = "src\\main\\resources\\de\\bcxp\\challenge\\weather.csv";
        DayTemperatureRepository dayTemperatureRepository = new DayTemperatureRepository();
        DayTemperatureService dayTemperatureService = new DayTemperatureService(dayTemperatureRepository);
        int dayWithSmallestTempSpread = dayTemperatureService.getDayWithSmallestSpread(fileNameWeather);     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);

        String fileNameCountry = "src\\main\\resources\\de\\bcxp\\challenge\\countries.csv";
        CountryRepository countryRepository = new CountryRepository();
        CountryService countryService = new CountryService(countryRepository);
        String countryWithHighestPopulationDensity = countryService.getMostPopulatedCountry(fileNameCountry); // Your population density analysis function call …
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }
}
