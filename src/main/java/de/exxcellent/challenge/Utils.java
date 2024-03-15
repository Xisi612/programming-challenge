package de.exxcellent.challenge;

import java.util.Comparator;

/**
 * The class consists utils methods.
 */
public class Utils {

    /**
     * Calculates the spread of two int values.
     * @param valueA int value one.
     * @param valueB int value two.
     * @return the absolute spread of two int values as int value.
     */
    public static int calculateSpread(int valueA, int valueB) {
        return Math.abs(valueB - valueA);
    }

    /**
     * Calculate and compare the spread of two entries.
     * @param minOfEntryA minimum of entry A
     * @param maxOfEntryA maximum of entry A
     * @param minOfEntryB minimum of entry B
     * @param maxOfEntryB maximum of entry B
     * @return the value 0 if spread of entryA == spread of entryB; a value less than 0 if spread of entryA < spread of
     * entryB; and a value greater than 0 if spread of entryA > spread of entryB
     */
    public static int compareBySpread(int minOfEntryA, int maxOfEntryA, int minOfEntryB , int maxOfEntryB) {
        int spreadOfEntryA = Utils.calculateSpread(minOfEntryA, maxOfEntryA);
        int spreadOfEntryB = Utils.calculateSpread(minOfEntryB, maxOfEntryB);
        return Integer.compare(spreadOfEntryA, spreadOfEntryB);
    }

}