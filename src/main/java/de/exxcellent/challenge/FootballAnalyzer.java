package de.exxcellent.challenge;

import java.util.ArrayList;

public class FootballAnalyzer {

    private ArrayList<FootballEntry> footballDataList;

    public FootballAnalyzer(ArrayList<FootballEntry> footballDataList) {
        this.footballDataList = footballDataList;
    }

    public String getTeamWithSmallestGoalSpread(){
        this.footballDataList.sort(this::compareFootballEntryBySpread);
        return this.footballDataList.get(0).getTeam();
    }

    public int compareFootballEntryBySpread(FootballEntry entryA, FootballEntry entryB){
        return Utils.compareBySpread(entryA.getGoals(),entryA.getGoalsAllowed(),entryB.getGoals(),entryB.getGoalsAllowed());
    }

}
