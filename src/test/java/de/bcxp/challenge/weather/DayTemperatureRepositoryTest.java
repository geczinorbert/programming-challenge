package de.bcxp.challenge.weather;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DayTemperatureRepositoryTest {

    @Test
    void getDayTemperaturesFromFileTest() {
        String fileName = "src\\test\\java\\de\\bcxp\\challenge\\resources\\weatherTest.csv";
        DayTemperatureRepository dayTemperatureRepository = new DayTemperatureRepository();
        List<DayTemperature> temperaturesFromFile = dayTemperatureRepository.getDayTemperaturesFromFile(fileName);

        DayTemperature dayTemperature1 = new DayTemperature(1,88,59);
        DayTemperature dayTemperature2 = new DayTemperature(2,79,63);
        DayTemperature dayTemperature3= new DayTemperature(3,77,55);
        DayTemperature dayTemperature4 = new DayTemperature(4,77,59);

        assertEquals(dayTemperature1,temperaturesFromFile.get(0));
        assertEquals(dayTemperature2,temperaturesFromFile.get(1));
        assertEquals(dayTemperature3,temperaturesFromFile.get(2));
        assertEquals(dayTemperature4,temperaturesFromFile.get(3));

    }

    @Test
    void getDayTemperaturesFromFileEmptyTest() {
        String fileName = "src\\test\\java\\de\\bcxp\\challenge\\resources\\empty.csv";
        DayTemperatureRepository dayTemperatureRepository = new DayTemperatureRepository();
        List<DayTemperature> temperaturesFromFile = dayTemperatureRepository.getDayTemperaturesFromFile(fileName);
        assertTrue(temperaturesFromFile.isEmpty());
    }
}
