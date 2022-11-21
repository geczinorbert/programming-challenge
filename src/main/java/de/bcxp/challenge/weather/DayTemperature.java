package de.bcxp.challenge.weather;

/**
 * Bean to represent a Day with min and max temperatures
 */
public class DayTemperature {

    private int dayOfTheMonth;

    private int maximumTemperature;

    private int minimumTemperature;

    public DayTemperature(int dayOfTheMonth, int maximumTemperature, int minimumTemperature) {
        this.dayOfTheMonth = dayOfTheMonth;
        this.maximumTemperature = maximumTemperature;
        this.minimumTemperature = minimumTemperature;
    }

    public int getDayOfTheMonth() {
        return dayOfTheMonth;
    }

    public int getTemperatureDifference() {
        return this.maximumTemperature - this.minimumTemperature;
    }
}
