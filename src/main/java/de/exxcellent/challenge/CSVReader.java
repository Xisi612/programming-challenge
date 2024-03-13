package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CSVReader {

    public CSVReader(){

    }

    public ArrayList<WeatherEntry> getWeatherData (String pathFromResources) throws IOException {
        ArrayList<WeatherEntry> weatherDataList = new ArrayList<>();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(pathFromResources);
        if (inputStream == null) throw new IOException();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
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

        reader.close();
        return weatherDataList;
    }

    public ArrayList<FootballEntry> getFootballData (String pathFromResources){

        return null;
    }
}
