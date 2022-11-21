package de.bcxp.challenge.country;

import java.util.List;

public class CountryService {

    CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    /**
     * Method to get the biggest country based on density
     *
     * @param fileName the name of the file to be read
     * @return the country name of
     */
    public String getMostPopulatedCountry(String fileName) {
        List<Country> dayTemperatures = countryRepository.getCountriesFromFile(fileName);
        int minIndex = 0;
        for (int i = 1; i < dayTemperatures.size(); ++i) {
            if (dayTemperatures.get(i).getDensity() > dayTemperatures.get(minIndex).getDensity()) {
                minIndex = i;
            }
        }
        return dayTemperatures.get(minIndex).getName();
    }
}
