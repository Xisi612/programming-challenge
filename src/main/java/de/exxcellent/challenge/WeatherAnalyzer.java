package de.exxcellent.challenge;

import java.util.ArrayList;

public class WeatherAnalyzer {

    private ArrayList<WeatherEntry> weatherDataList;

    public WeatherAnalyzer(ArrayList<WeatherEntry> weatherDataList) {
        this.weatherDataList = weatherDataList;
    }

    public String getDayWithSmallestTempSpread(){
        this.weatherDataList.sort(Utils::compareWeatherBySpread);
        return this.weatherDataList.get(weatherDataList.size()-1).getDay();
    }
}