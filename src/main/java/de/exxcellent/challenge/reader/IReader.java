package de.exxcellent.challenge.reader;

import de.exxcellent.challenge.models.FootballEntry;
import de.exxcellent.challenge.models.WeatherEntry;

import java.util.ArrayList;
import java.util.Optional;

public interface IReader {

    Optional<ArrayList<WeatherEntry>> getWeatherData(String source);

    Optional<ArrayList<FootballEntry>> getFootballData(String source);
}
