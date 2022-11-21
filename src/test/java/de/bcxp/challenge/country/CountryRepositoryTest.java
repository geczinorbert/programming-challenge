package de.bcxp.challenge.country;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CountryRepositoryTest {

    @Test
    void getCountriesFromFileTest() {
        String fileName = "src\\test\\java\\de\\bcxp\\challenge\\resources\\countriesTest.csv";
        CountryRepository countryRepository = new CountryRepository();
        List<Country> countries = countryRepository.getCountriesFromFile(fileName);

        Country country1 = new Country("Austria", 8926000, 83855);
        Country country2 = new Country("See", 49036355, 965944);
        Country country3 = new Country("Croatia", 4036355, 56594);
        Country country4 = new Country("Cyprus", 896000, 9251);

        assertEquals(country1, countries.get(0));
        assertEquals(country2, countries.get(1));
        assertEquals(country3, countries.get(2));
        assertEquals(country4, countries.get(3));

    }

    @Test
    void getDayTemperaturesFromFileEmptyTest() {
        String fileName = "src\\test\\java\\de\\bcxp\\challenge\\resources\\empty.csv";
        CountryRepository countryRepository = new CountryRepository();
        List<Country> countries = countryRepository.getCountriesFromFile(fileName);
        assertTrue(countries.isEmpty());
    }

    @Test
    void getDayTemperaturesFromFileWrongDatasetTest() {
        String fileName = "src\\test\\java\\de\\bcxp\\challenge\\resources\\wrongCountriesTest.csv";
        CountryRepository countryRepository = new CountryRepository();
        List<Country> countries = countryRepository.getCountriesFromFile(fileName);
        assertFalse(countries.isEmpty());
    }
}
