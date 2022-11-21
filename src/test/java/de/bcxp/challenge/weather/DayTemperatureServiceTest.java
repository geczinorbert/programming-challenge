package de.bcxp.challenge.weather;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayTemperatureServiceTest {
    private DayTemperatureService dayTemperatureService;

    @Mock
    private DayTemperatureRepository dayTemperatureRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        dayTemperatureService = new DayTemperatureService(dayTemperatureRepository);
    }

    @Test
    public void getColdestDayOfTheMonthTest() {
        String fileName = "src\\test\\java\\de\\bcxp\\challenge\\resources\\weatherTest.csv";

        DayTemperature dayTemperature1 = new DayTemperature(1,88,59);
        DayTemperature dayTemperature2 = new DayTemperature(2,79,63);
        DayTemperature dayTemperature3= new DayTemperature(3,77,55);
        DayTemperature dayTemperature4 = new DayTemperature(4,77,59);

        List<DayTemperature> dayTemperatureList = List.of(dayTemperature1, dayTemperature2, dayTemperature3, dayTemperature4);
        Mockito.when(dayTemperatureRepository.getDayTemperaturesFromFile(Mockito.any())).thenReturn(dayTemperatureList);

        int coldestDayOfTheMonth = dayTemperatureService.getDayWithSmallestSpread(fileName);
        assertEquals(2,coldestDayOfTheMonth);
    }
}
