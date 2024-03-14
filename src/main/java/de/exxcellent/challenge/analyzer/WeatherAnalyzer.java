package de.exxcellent.challenge.analyzer;

import de.exxcellent.challenge.Utils;
import de.exxcellent.challenge.models.WeatherEntry;

import java.util.ArrayList;

public class WeatherAnalyzer {

    private ArrayList<WeatherEntry> weatherDataList;

    public WeatherAnalyzer(ArrayList<WeatherEntry> weatherDataList) {
        this.weatherDataList = weatherDataList;
    }

    public String getDayWithSmallestTempSpread(){
        this.weatherDataList.sort(this::compareWeatherBySpread);
        return this.weatherDataList.get(0).getDay();
    }

    public int compareWeatherBySpread(WeatherEntry entryA, WeatherEntry entryB){
        return Utils.compareBySpread(entryA.getMnt(),entryA.getMxt(),entryB.getMnt(),entryB.getMxt());
    }
}