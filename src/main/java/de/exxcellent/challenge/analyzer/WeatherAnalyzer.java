package de.exxcellent.challenge.analyzer;

import de.exxcellent.challenge.Utils;
import de.exxcellent.challenge.models.WeatherEntry;

import java.util.ArrayList;

public class WeatherAnalyzer {

    private ArrayList<WeatherEntry> weatherDataList;

    public WeatherAnalyzer(ArrayList<WeatherEntry> weatherDataList) {
        this.weatherDataList = weatherDataList;
    }

    /**
     * Sorts list of weather entries by smallest temperature spread and then returns the day of the first entry.
     *
     * @return day of the entry with the smallest temperature spread.
     */
    public String getDayWithSmallestTempSpread() {
        this.weatherDataList.sort(this::compareWeatherBySpread);
        return this.weatherDataList.get(0).getDay();
    }

    /**
     * Compares the goals spread of two weather entries.
     *
     * @param entryA WeatherEntry of entry one.
     * @param entryB WeatherEntry of entry two.
     * @return the value 0 if spread of entryA == spread of entryB; a value less than 0 if spread of entryA < spread of
     * entryB; and a value greater than 0 if spread of entryA > spread of entryB
     */
    public int compareWeatherBySpread(WeatherEntry entryA, WeatherEntry entryB) {
        return Utils.compareBySpread(entryA.getMnt(), entryA.getMxt(), entryB.getMnt(), entryB.getMxt());
    }
}