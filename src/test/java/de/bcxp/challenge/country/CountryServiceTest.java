package de.bcxp.challenge.country;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryServiceTest {
    private CountryService countryService;

    @Mock
    private CountryRepository countryRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        countryService = new CountryService(countryRepository);
    }

    @Test
    public void getColdestDayOfTheMonthTest() {
        String fileName = "anything";

        Country country1 = new Country("Austria", 8926000, 83855);
        Country country2 = new Country("See", 49036355, 965944);
        Country country3 = new Country("Croatia", 4036355, 56594);
        Country country4 = new Country("Cyprus", 896000, 9251);

        List<Country> countries = List.of(country1, country2, country3, country4);
        Mockito.when(countryRepository.getCountriesFromFile(Mockito.any())).thenReturn(countries);

        String biggestCountry = countryService.getMostPopulatedCountry(fileName);
        assertEquals("Austria", biggestCountry);
    }
}
