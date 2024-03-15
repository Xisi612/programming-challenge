package de.exxcellent.challenge;

import de.exxcellent.challenge.analyzer.FootballAnalyzer;
import de.exxcellent.challenge.models.FootballEntry;
import de.exxcellent.challenge.reader.CSVReader;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FootballTest {

    @Test
    void testGetFootballDataList() {
        ArrayList<FootballEntry> expectedFootballDataList = new ArrayList<>();
        expectedFootballDataList.add(new FootballEntry("Arsenal", 79, 36));
        expectedFootballDataList.add(new FootballEntry("Liverpool", 67, 30));
        expectedFootballDataList.add(new FootballEntry("Manchester United", 87, 45));

        String path = "de/exxcellent/challenge/football.csv";
        CSVReader csvReader = new CSVReader();
        Optional<ArrayList<FootballEntry>> footballDataList = csvReader.getFootballData(path);

        assertTrue(footballDataList.isPresent());
        assertEquals(expectedFootballDataList, footballDataList.get());
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
