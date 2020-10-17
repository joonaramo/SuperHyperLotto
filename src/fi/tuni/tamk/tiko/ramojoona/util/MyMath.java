package fi.tuni.tamk.tiko.ramojoona.util;

/**
 * The class MyMath contains methods for some basic tasks with numbers
 * 
 * The class will make it easier for us to for example calculate or generate
 * values based on params we are giving
 * 
 * @author Joona Rämö
 */

public class MyMath {
    /**
     * Returns a random value between min and max.
     * 
     * Method is given two values, and it will use Java's Math.random() method to
     * create a random integer between those values
     * 
     * @param min the minimum value
     * @param max the maximum value
     * @return a random value between min and max
     */
    public static int getRandom(int min, int max) {
        return min + (int) (java.lang.Math.random() * ((max - min) + 1));
    }

    /**
     * Removes an index from array and returns it
     * 
     * Method is given an array and an index. When it gets to the index, it removes
     * it's value and continues. New array will be one shorten than the original.
     * 
     * @param numbers the original array
     * @param index   index to remove
     * @return new array with the index removed
     */

    public static int[] removeIndex(int[] numbers, int index) {
        int[] newArray = new int[numbers.length - 1];

        boolean indexFound = false;
        for (int i = 0; i < newArray.length; i++) {
            if (i == index) {
                indexFound = true;
            }
            if (indexFound) {
                newArray[i] = numbers[i + 1];
            } else {
                newArray[i] = numbers[i];
            }
        }

        return newArray;
    }
}