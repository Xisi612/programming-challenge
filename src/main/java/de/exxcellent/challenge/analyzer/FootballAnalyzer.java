package de.exxcellent.challenge.analyzer;

import de.exxcellent.challenge.models.FootballEntry;
import de.exxcellent.challenge.Utils;

import java.util.ArrayList;

/**
 * This class gives methods to analyse a list of football entries.
 */
public class FootballAnalyzer {

    private ArrayList<FootballEntry> footballDataList;

    public FootballAnalyzer(ArrayList<FootballEntry> footballDataList) {
        this.footballDataList = footballDataList;
    }

    /**
     * Sorts list of football entries by smallest goal spread and then returns the team name of the first entry.
     *
     * @return team name of the entry with the smallest goal spread.
     */
    public String getTeamWithSmallestGoalSpread() {
        this.footballDataList.sort(this::compareFootballEntryBySpread);
        return this.footballDataList.get(0).getTeam();
    }

    /**
     * Compares the goals spread of two football entries.
     *
     * @param entryA FootballEntry of entry one.
     * @param entryB FootballEntry of entry two.
     * @return the value 0 if spread of entryA == spread of entryB; a value less than 0 if spread of entryA < spread of
     * entryB; and a value greater than 0 if spread of entryA > spread of entryB
     */
    public int compareFootballEntryBySpread(FootballEntry entryA, FootballEntry entryB) {
        return Utils.compareBySpread(entryA.getGoals(), entryA.getGoalsAllowed(), entryB.getGoals(), entryB.getGoalsAllowed());
    }

}
