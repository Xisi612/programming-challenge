package de.exxcellent.challenge.models;

import java.util.Objects;

/**
 * Models the data of a football entry.
 */
public class FootballEntry {

    private String team;
    private int goals;
    private int goalsAllowed;

    //... other parameters

    public FootballEntry(String team, int goals, int goalsAllowed) {
        this.team = team;
        this.goals = goals;
        this.goalsAllowed = goalsAllowed;
    }

    public String getTeam() {
        return team;
    }

    public int getGoals() {
        return goals;
    }

    public int getGoalsAllowed() {
        return goalsAllowed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballEntry that = (FootballEntry) o;
        return goals == that.goals && goalsAllowed == that.goalsAllowed && Objects.equals(team, that.team);
    }
}
