package de.bcxp.challenge.country;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryTest {
    @Test
    void getDensityTest() {
        Country smallCountry = new Country("MySmallCountry", 55555, 11111);
        Country averageCountry = new Country("MyAverageCountry", 1748415, 18944);
        Country bigCountry = new Country("MyBigCountry", 1545654645, 103043643);


        assertEquals(5, smallCountry.getDensity());
        assertEquals(92.29386613175676, averageCountry.getDensity());
        assertEquals(15, bigCountry.getDensity());
    }
}
