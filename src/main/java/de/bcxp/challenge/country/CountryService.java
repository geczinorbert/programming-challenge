package de.bcxp.challenge.country;

import java.util.List;

public class CountryService {

    CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    public String getMostPopulatedCountry(String fileName) {
        List<Country> dayTemperatures = countryRepository.getCountriesFromFile(fileName);
        int minIndex = 0;
        for(int i=1; i < dayTemperatures.size(); ++i){
            if(dayTemperatures.get(i).getDensity() > dayTemperatures.get(minIndex).getDensity()){
                minIndex = i;
            }
        }
        return dayTemperatures.get(minIndex).getName();
    }
}
