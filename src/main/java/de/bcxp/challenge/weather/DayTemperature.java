package de.bcxp.challenge.weather;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DayTemperature that = (DayTemperature) o;
        return dayOfTheMonth == that.dayOfTheMonth && maximumTemperature == that.maximumTemperature && minimumTemperature == that.minimumTemperature;
    }    @Override
    public int hashCode() {
        return Objects.hash(dayOfTheMonth, maximumTemperature, minimumTemperature);
    }
}
