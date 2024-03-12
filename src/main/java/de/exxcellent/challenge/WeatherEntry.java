package de.exxcellent.challenge;

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

}