package de.exxcellent.challenge.reader;

import de.exxcellent.challenge.models.FootballEntry;
import de.exxcellent.challenge.models.WeatherEntry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Optional;

/**
 * The class consists methode to parse csv files.
 */
public class CSVReader implements IReader {

    public CSVReader() {

    }

    /**
     * Parse data of source in list of weather entries.
     *
     * @param source Path to source-file.
     * @return Optional ArrayList of type WeatherEntry. If the source can't be accessed, the Optional holds no value.
     */
    public Optional<ArrayList<WeatherEntry>> getWeatherData(String source) {
        ArrayList<WeatherEntry> weatherDataList = new ArrayList<>();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(source);
        if (inputStream == null) {
            System.err.println("File could not be found. Please check whether the file is available under the following path: resources/" + source);
            return Optional.empty();
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            // skip header-line
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                WeatherEntry entry = new WeatherEntry(parts[0],
                        Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2]));
                weatherDataList.add(entry);
            }

            return Optional.of(weatherDataList);

        } catch (IOException e) {
            System.err.println("File " + source + " could not be read.");
            return Optional.empty();
        }

    }


    /**
     * Parse data of source in list of football entries.
     *
     * @param source Path to source-file.
     * @return Optional ArrayList of type FootballEntry. If the source can't be accessed, the Optional holds no value.
     */
    public Optional<ArrayList<FootballEntry>> getFootballData(String source) {
        ArrayList<FootballEntry> footballDataList = new ArrayList<>();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(source);
        if (inputStream == null) {
            System.err.println("File could not be found. Please check whether the file is available under the following path: resources/" + source);
            return Optional.empty();
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            // skip header-line
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                FootballEntry entry = new FootballEntry(parts[0],
                        Integer.parseInt(parts[5]),
                        Integer.parseInt(parts[6]));
                footballDataList.add(entry);
            }

            return Optional.of(footballDataList);

        } catch (IOException e) {

            System.err.println("File" + source + "could not be read.");
            return Optional.empty();

        }

    }
}
