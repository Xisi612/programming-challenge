package de.exxcellent.challenge;

import java.util.Comparator;

public class Utils {
    public static int calculateSpread(int valueA, int valueB){
        return Math.abs(valueB-valueA);
    }

    public static int compareBySpread(int minValueA, int maxValueA, int minValueB, int maxValueB){
        int spreadOfEntryA = Utils.calculateSpread(minValueA, maxValueA);
        int spreadOfEntryB = Utils.calculateSpread(minValueB, maxValueB);
        return Integer.compare(spreadOfEntryA, spreadOfEntryB);
    }

}