package fi.tuni.tamk.tiko.ramojoona.util;

import java.io.Console;

/**
 * A class that has methods based on the user's input.
 * 
 * @author Joona Rämö
 */

public class MyConsole {

    /**
     * A method that asks user for an integer between a min and max value until
     * given a valid one and returns it
     * 
     * @param errorMessageNonNumeric   the error message that will be shown to user
     *                                 if the number is not an integer
     * @param errorMessageNonMinAndMax the error message that will be shown to user
     *                                 if the number is not between min and max
     *                                 value
     * @return returns the value that user entered into the console
     */
    public static int readInt(int min, int max, String errorMessageNonNumeric, String errorMessageNonMinAndMax) {

        Console c = System.console();
        boolean invalidInput = true;

        while (invalidInput) {
            try {
                int input = Integer.parseInt(c.readLine());
                if (input < min || input > max) {
                    invalidInput = true;
                    System.out.println(errorMessageNonMinAndMax);
                } else {
                    invalidInput = false;
                    return input;
                }
            } catch (NumberFormatException e) {
                invalidInput = true;
                System.out.println(errorMessageNonNumeric);
            }
        }
        return 0;

    }
}