package de.exxcellent.challenge;

import de.exxcellent.challenge.analyzer.FootballAnalyzer;
import de.exxcellent.challenge.analyzer.WeatherAnalyzer;
import de.exxcellent.challenge.models.FootballEntry;
import de.exxcellent.challenge.models.WeatherEntry;
import de.exxcellent.challenge.reader.CSVReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     *
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        String pathFromResourcesWeather = "de/exxcellent/challenge/weather.csv";
        String pathFromResourcesFootball = "de/exxcellent/challenge/football.csv";

        CSVReader csvReader = new CSVReader();
        Optional<ArrayList<WeatherEntry>> weatherDataList = csvReader.getWeatherData(pathFromResourcesWeather);
        Optional<ArrayList<FootballEntry>> footballDataList = csvReader.getFootballData(pathFromResourcesFootball);

        if (weatherDataList.isPresent()) {
            WeatherAnalyzer weatherAnalyzer = new WeatherAnalyzer(weatherDataList.get());
            String dayWithSmallestTempSpread = weatherAnalyzer.getDayWithSmallestTempSpread();
            System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        } else {
            System.out.println("Weather data is not available and could therefore not be analyzed");
        }

        if (footballDataList.isPresent()) {
            FootballAnalyzer footballAnalyzer = new FootballAnalyzer(footballDataList.get());
            String teamWithSmallestGoalSpread = footballAnalyzer.getTeamWithSmallestGoalSpread();
            System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
        } else {
            System.out.println("Weather data is not available and could therefore not be analyzed");
        }

    }

}
