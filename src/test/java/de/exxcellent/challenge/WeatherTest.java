package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeatherTest {

    @Test
    void testGetWeatherDataList(){
        ArrayList<WeatherEntry> expectedWeatherDataList = new ArrayList<>();
        expectedWeatherDataList.add(new WeatherEntry("1",88,59));
        expectedWeatherDataList.add(new WeatherEntry("2",79,63));
        expectedWeatherDataList.add(new WeatherEntry("3",77,55));

        String path = "de/exxcellent/challenge/weather.csv";
        CSVReader csvReader = new CSVReader();
        ArrayList<WeatherEntry> weatherDataList = csvReader.getWeatherData(path);

        assertEquals(expectedWeatherDataList, weatherDataList);
    }

   @Test
   void testGetDayWithSmallestTempSpread(){
        String expectedDay = "1";
        ArrayList<WeatherEntry> weatherDataList = new ArrayList<>();
        weatherDataList.add(new WeatherEntry("1",88,59));
        weatherDataList.add(new WeatherEntry("2",79,63));
        weatherDataList.add(new WeatherEntry("3",77,55));

        WeatherAnalyzer weatherAnalyzer = new WeatherAnalyzer(weatherDataList);
        String day = weatherAnalyzer.getDayWithSmallestTempSpread();

        assertEquals(expectedDay, day);
   }

}
