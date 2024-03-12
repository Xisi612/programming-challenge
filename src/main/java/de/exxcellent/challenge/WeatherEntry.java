package de.exxcellent.challenge;

import java.util.Objects;

public class WeatherEntry{

    private String day;
    private int mxt;
    private int mnt;

    public WeatherEntry(String day, int mxt, int mnt) {
        this.day = day;
        this.mxt = mxt;
        this.mnt = mnt;
    }

    public String getDay() {
        return day;
    }

    public int getMxt() {
        return mxt;
    }

    public int getMnt() {
        return mnt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherEntry that = (WeatherEntry) o;
        return mxt == that.mxt && mnt == that.mnt && Objects.equals(day, that.day);
    }

}