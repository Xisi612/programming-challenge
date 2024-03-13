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

        String pathFromResourcesWeather = "de/exxcellent/challenge/weather.csv";
        String pathFromResourcesFootball = "de/exxcellent/challenge/football.csv";

        CSVReader csvReader = new CSVReader();
        ArrayList <WeatherEntry> weatherDataList = new ArrayList<>();
        try {
            weatherDataList = csvReader.getWeatherData(pathFromResourcesWeather);

        } catch (IOException e) {
            System.err.println("File could not be loaded. Please check whether the file is available under the following path: " + pathFromResourcesWeather);
            System.exit(1);
        }

        ArrayList <FootballEntry> footballDataList = new ArrayList<>();
        try {
            footballDataList = csvReader.getFootballData(pathFromResourcesFootball);

        } catch (IOException e) {
            System.err.println("File could not be loaded. Please check whether the file is available under the following path: " + pathFromResourcesFootball);
            System.exit(1);
        }

        WeatherAnalyzer weatherAnalyzer = new WeatherAnalyzer(weatherDataList);
        FootballAnalyzer footballAnalyzer = new FootballAnalyzer(footballDataList);

        String dayWithSmallestTempSpread = weatherAnalyzer.getDayWithSmallestTempSpread();
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        String teamWithSmallestGoalSpread = footballAnalyzer.getTeamWithSmallestGoalSpread();
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
    }

}
