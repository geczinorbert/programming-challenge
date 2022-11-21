package de.bcxp.challenge.weather;

import java.util.List;

public class DayTemperatureService {

    DayTemperatureRepository dayTemperatureRepository;

    public DayTemperatureService(DayTemperatureRepository dayTemperatureRepository) {
        this.dayTemperatureRepository = dayTemperatureRepository;
    }

    public int getColdestDayOfTheMonth(String fileName) {
        List<DayTemperature> dayTemperaturesFromFile = dayTemperatureRepository.getDayTemperaturesFromFile(fileName);
        return 0;
    }
}
