package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FootballTest {

    @Test
    void testGetFootballDataList(){
        ArrayList<FootballEntry> expectedFootballDataList = new ArrayList<>();
        expectedFootballDataList.add(new FootballEntry("Arsenal",79,36));
        expectedFootballDataList.add(new FootballEntry("Liverpool",67,30));
        expectedFootballDataList.add(new FootballEntry("Manchester United",87,45));

        String path = "de/exxcellent/challenge/football.csv";
        CSVReader csvReader = new CSVReader();
        ArrayList<FootballEntry> footballDataList;

        try {
            footballDataList = csvReader.getFootballData(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        assertEquals(expectedFootballDataList, footballDataList);
    }

    @Test
    void testGetTeamWithSmallestGoalSpread(){
        String expectedTeam = "Liverpool";
        ArrayList<FootballEntry> footballDataList = new ArrayList<>();
        footballDataList.add(new FootballEntry("Arsenal",79,36));
        footballDataList.add(new FootballEntry("Liverpool",67,30));
        footballDataList.add(new FootballEntry("Manchester United",87,45));

        FootballAnalyzer footballAnalyzer = new FootballAnalyzer(footballDataList);
        String team = footballAnalyzer.getTeamWithSmallestGoalSpread();

        assertEquals(expectedTeam, team);
    }
}