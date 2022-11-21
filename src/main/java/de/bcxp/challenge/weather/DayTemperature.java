package de.bcxp.challenge.weather;

public class DayTemperature {

    private int dayOfTheMonth;

    private int maximumTemperature;

    private int minimumTemperature;

    public int getTemperatureDifference() {
        return this.maximumTemperature - this.minimumTemperature;
    }
}
