package fi.tuni.tamk.tiko.ramojoona.util;

/**
 * The class MyArrays contains methods that help to work with arrays
 * 
 * @author Joona Rämö
 */

public class MyArrays {
    /**
     * Takes an array of type String and returns it as of type int.
     * 
     * Method is given a String array, and it will loop through all the Strings and
     * convert them into integers.
     * 
     * @param array the array we want to transform
     * @return
     */
    public static int[] toIntArray(String[] array) {
        int[] intArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            intArray[i] = Integer.parseInt(array[i]);
        }
        return intArray;
    }

    /**
     * Takes a value and a int array, and finds out if the array has that value
     * 
     * @param value the integer value we are looking for
     * @param array the array we are searching the value from
     * @return true if found, false if not
     */
    public static boolean contains(int value, int[] array) {
        boolean found = false;
        for (int i = 0; i < array.length && !found; i++) {
            if (array[i] == value) {
                found = true;
            }
        }
        return found;
    }

    /**
     * Takes an array and prints that with prefix
     * 
     * @param array        the array we want to print
     * @param prefixChar   the character we want to prefix the array's values with
     * @param prefixLength the length of the prefix we want (max)
     * 
     */
    public static void printWithPrefix(int[] array, char prefixChar, int prefixLength) {
        String arrayString = "[";
        for (int i = 0; i < array.length; i++) {
            String numberAsString = array[i] + "";
            int stringLenght = numberAsString.length();
            int prefixCharsNeeded = prefixLength - stringLenght + 1;

            String prefixString = "";
            for (int j = 0; j < prefixCharsNeeded; j++) {
                prefixString += prefixChar;
            }

            if (i < array.length - 1) {
                arrayString += prefixString + array[i] + ",";
            } else {
                arrayString += prefixString + array[i] + "]";
            }
        }
        System.out.println(arrayString); // [1,2,3,4,5,6,7]
    }

    /**
     * Takes two arrays and checks how many same values they have.
     * 
     * @param array1 an array we are looping through to get total amount of same
     *               values
     * @param array2 another array we are looping through
     * @return number of the same values in arrays
     */
    public static int containsSameValues(int[] array1, int[] array2) {
        int amountOfSameValues = 0;

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    amountOfSameValues++;
                }
            }
        }
        return amountOfSameValues;
    }

    /**
     * Takes an array and uses selection sort -algorithm to sort it from the
     * smallest to the largest value
     * 
     * @param array the array we want to sort
     * @return the sorted array
     */
    public static int[] sort(int[] array) {
        // Array = [7, 3, ...]
        for (int i = 0; i < array.length - 1; i++) {
            int minValue = i; // 0 (indeksi)
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minValue]) { // 3 < 7
                    minValue = j; // 1 (indeksi)
                }
            }
            int newMinValue = array[minValue]; // 3
            array[minValue] = array[i]; // array[1] = 3
            array[i] = newMinValue; // array[0] = 7
        }
        return array;
    }

}