package de.exxcellent.challenge;

import de.exxcellent.challenge.analyzer.WeatherAnalyzer;
import de.exxcellent.challenge.models.WeatherEntry;
import de.exxcellent.challenge.reader.CSVReader;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WeatherTest {

    @Test
    void testGetWeatherDataList() {
        ArrayList<WeatherEntry> expectedWeatherDataList = new ArrayList<>();
        expectedWeatherDataList.add(new WeatherEntry("1", 88, 59));
        expectedWeatherDataList.add(new WeatherEntry("2", 79, 63));
        expectedWeatherDataList.add(new WeatherEntry("3", 77, 55));

        String path = "de/exxcellent/challenge/weather.csv";
        CSVReader csvReader = new CSVReader();
        Optional<ArrayList<WeatherEntry>> weatherDataList = csvReader.getWeatherData(path);

        assertTrue(weatherDataList.isPresent());
        assertEquals(expectedWeatherDataList, weatherDataList.get());
    }

   @Test
   void testGetDayWithSmallestTempSpread(){
        String expectedDay = "2";
        ArrayList<WeatherEntry> weatherDataList = new ArrayList<>();
        weatherDataList.add(new WeatherEntry("1",88,59));
        weatherDataList.add(new WeatherEntry("2",79,63));
        weatherDataList.add(new WeatherEntry("3",77,55));

        WeatherAnalyzer weatherAnalyzer = new WeatherAnalyzer(weatherDataList);
        String day = weatherAnalyzer.getDayWithSmallestTempSpread();

        assertEquals(expectedDay, day);
   }

}
