package de.bcxp.challenge.weather;

import java.util.List;

public class DayTemperatureService {

    DayTemperatureRepository dayTemperatureRepository;

    public DayTemperatureService(DayTemperatureRepository dayTemperatureRepository) {
        this.dayTemperatureRepository = dayTemperatureRepository;
    }

    /**
     * Return the day of the Month which has the smallest spread in temperature
     * @param fileName
     * @return
     */
    public int getDayWithSmallestSpread(String fileName) {
        List<DayTemperature> dayTemperatures = dayTemperatureRepository.getDayTemperaturesFromFile(fileName);
        int minIndex = 0;
        for(int i=1; i < dayTemperatures.size(); ++i){
            if(dayTemperatures.get(i).getTemperatureDifference() < dayTemperatures.get(minIndex).getTemperatureDifference()){
                minIndex = i;
            }
        }
        return dayTemperatures.get(minIndex).getDayOfTheMonth();
    }
}
