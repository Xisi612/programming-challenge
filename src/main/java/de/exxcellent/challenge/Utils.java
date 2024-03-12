package de.exxcellent.challenge;

import java.util.Comparator;

public class Utils {
    public static int calculateSpread(int valueA, int valueB){
        return Math.abs(valueB-valueA);
    }

    public static int compareWeatherBySpread(WeatherEntry weatherEntryA, WeatherEntry weatherEntryB){
        int spreadOfWeatherEntryA = Utils.calculateSpread(weatherEntryA.getMnt(), weatherEntryA.getMxt());
        int spreadOfWeatherEntryB = Utils.calculateSpread(weatherEntryB.getMnt(), weatherEntryB.getMxt());
        return Integer.compare(spreadOfWeatherEntryA, spreadOfWeatherEntryB);
    }

}