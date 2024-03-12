package de.exxcellent.challenge;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        String pathFromResources = "de/exxcellent/challenge/weather.csv";

        CSVReader csvReader = new CSVReader();
        ArrayList <WeatherEntry> weatherDataList = new ArrayList<>();
        try {
            weatherDataList = csvReader.getWeatherData(pathFromResources);
        } catch (IOException e) {
            System.err.println("File could not be loaded. Please check whether the file is available under the following path: " + pathFromResources);
            System.exit(1);
        }
        WeatherAnalyzer weatherAnalyzer = new WeatherAnalyzer(weatherDataList);

        String dayWithSmallestTempSpread = weatherAnalyzer.getDayWithSmallestTempSpread();
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }

}
