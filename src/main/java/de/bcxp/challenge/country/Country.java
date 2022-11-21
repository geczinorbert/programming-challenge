package de.bcxp.challenge.country;

import java.util.Objects;

public class Country {

    private String name;

    private double population;

    private double area;

    public Country(String name, double population, double area) {
        this.name = name;
        this.population = population;
        this.area = area;
    }

    public double getDensity(){
        return population / area;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Double.compare(country.population, population) == 0 && Double.compare(country.area, area) == 0 && Objects.equals(name, country.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, population, area);
    }
}
