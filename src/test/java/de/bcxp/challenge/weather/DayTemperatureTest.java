package de.bcxp.challenge.weather;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayTemperatureTest {

    @Test
    void temperatureDifferenceTest() {
        DayTemperature dayTemperatureCold = new DayTemperature(1, -55, -75);
        DayTemperature dayTemperatureWarm = new DayTemperature(1, 55, 75);
        DayTemperature dayTemperatureHot = new DayTemperature(1, 200, -50);


        assertEquals(20, dayTemperatureCold.getTemperatureDifference());
        assertEquals(-20, dayTemperatureWarm.getTemperatureDifference());
        assertEquals(250, dayTemperatureHot.getTemperatureDifference());

    }
}
