package fi.tuni.tamk.tiko.ramojoona;

import fi.tuni.tamk.tiko.ramojoona.util.MyArrays;
import fi.tuni.tamk.tiko.ramojoona.util.MyConsole;
import fi.tuni.tamk.tiko.ramojoona.util.MyMath;
import java.io.Console;

/**
 * Lotto App
 * 
 * An app you can play lotto on. Pick your numbers and cross your fingers for
 * the jackpot!
 * 
 * @author Joona Rämö
 */

public class Lotto {
    static boolean GAME_CRASHED = false;
    static final int LOTTO_NUMBERS_AMOUNT = 7;
    static final int LOTTO_NUMBERS_MAXIMUM = 40;

    public static void main(String[] args) {
        Console c = System.console();
        boolean userWon = false;

        int[] userNumbers = getUserLottoNumbers(args);

        // Keep running the game only if it did not crash during getting the
        // user's numbers
        if (!GAME_CRASHED) {
            boolean outputInfo = false;
            String userDecision = "";

            // Ask user if he wants the lotto numbers to be outputted
            while (!(userDecision.equalsIgnoreCase("y") || userDecision.equalsIgnoreCase("n"))) {
                System.out.println("Do you want correct lotto numbers and your numbers as output? (Y/N)");
                userDecision = c.readLine();
            }

            if (userDecision.equalsIgnoreCase("y")) {
                outputInfo = true;
            } else if (userDecision.equalsIgnoreCase("n")) {
                outputInfo = false;
            }

            int weeks = 0;
            int numbersFound = 0;

            // Run this only if user has not already won the lotto
            while (!userWon) {
                weeks++; // iterate weeks each time we run the code
                int[] lottoNumbers = calculateLotto(); // generate random numbers as our lotto numbers
                int sameNumbers = compareNumbers(userNumbers, lottoNumbers); // compare how many same numbers is in the
                                                                             // user's selected numbers and randomly
                                                                             // generated ones

                // Check if there is one more same number than ever before and depending on
                // user's choice, output the lotto and user's numbers. Print how many same
                // numbers there was and how many times it ran
                if (sameNumbers == numbersFound + 1) {
                    numbersFound++;
                    if (outputInfo == true) {
                        outputNumbers(lottoNumbers, userNumbers);
                    }
                    System.out.println("Got " + sameNumbers + " right! Took " + weeks / 52 + " years");
                }

                // If all numbers are the same, user won the lotto. Check if user won the lotto
                // within 120 years and reset the game values if not so the game starts again
                if (numbersFound == LOTTO_NUMBERS_AMOUNT) {
                    System.out.println("You won!");
                    if (weeks / 52 < 120) {
                        userWon = true;
                    } else {
                        weeks = 0;
                        numbersFound = 0;
                        System.out.println("Although it took more than a lifetime, let's try it again.");
                    }
                }
            }
        }
    }

    /**
     * Generates random unique lotto numbers
     * 
     * @return array of the randomly generated lotto numbers
     */
    private static int[] calculateLotto() {
        int numbersGenerated = 0;

        int[] lottoNumbers = new int[LOTTO_NUMBERS_AMOUNT];

        // array contains 1 ... 40
        int[] numbers = new int[LOTTO_NUMBERS_MAXIMUM];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1; // numbers[0] == 1 ... numbers[39] = 40
        }

        while (numbersGenerated < LOTTO_NUMBERS_AMOUNT) {

            // get random index from the array
            int index = MyMath.getRandom(0, numbers.length - 1); // 0-39

            // get some random number from the array
            int randomNumber = numbers[index];

            // put it into lotto
            lottoNumbers[numbersGenerated] = randomNumber;

            // remove the index from the array so the same number can't be generated twice
            numbers = MyMath.removeIndex(numbers, index);

            numbersGenerated++;

        }
        return lottoNumbers;
    }

    /**
     * Gets the user-selected unique lotto numbers.
     * 
     * User can either pass in the lotto numbers as command line arguments or if
     * arguments are not passed, it will ask those within the app.
     * 
     * @param args the command line arguments
     * @return an array of the user's numbers
     */
    private static int[] getUserLottoNumbers(String[] args) {
        int[] numbersArr = new int[LOTTO_NUMBERS_AMOUNT];

        // If there is correct amount of command line arguments, use them as user's
        // numbers, otherwise ask them separately
        if (args.length == LOTTO_NUMBERS_AMOUNT) {
            for (int i = 0; i < LOTTO_NUMBERS_AMOUNT; i++) {
                int number = Integer.parseInt(args[i]);
                boolean foundAlready = MyArrays.contains(number, numbersArr); // checks if the number is already
                                                                              // selected
                // if the number is already selected, the game will crash, otherwise the number
                // will be added in to the user's numbers array
                if (foundAlready) {
                    System.out.println("You did not give unique numbers!");
                    GAME_CRASHED = true;
                } else {
                    numbersArr[i] = number;
                }
            }
        } else {
            for (int i = 0; i < LOTTO_NUMBERS_AMOUNT; i++) {
                System.out.println("Please give unique number between [1, " + LOTTO_NUMBERS_MAXIMUM + "]");
                int number = MyConsole.readInt(1, LOTTO_NUMBERS_MAXIMUM, "Please give number.",
                        "Please give unique number between [1, " + LOTTO_NUMBERS_MAXIMUM + "]");
                boolean foundAlready = MyArrays.contains(number, numbersArr);
                if (foundAlready) {
                    System.out.println("Not a unique number!");
                    i--;
                } else {
                    numbersArr[i] = number;
                }
            }
        }

        return numbersArr;
    }

    /**
     * A method that compares the random lotto numbers and user's numbers and
     * returns how many same values they had
     * 
     * Uses the compareNumbers-method to find out the amount of same values between
     * two arrays
     * 
     * @param lottoNumbers randomly generated lotto numbers
     * @param userNumbers  user selected numbers
     * @return the amount of same numbers in the two arrays
     */
    private static int compareNumbers(int[] userNumbers, int[] lottonNumbers) {
        int amountOfSameValues = MyArrays.containsSameValues(userNumbers, lottonNumbers);
        return amountOfSameValues;
    }

    /**
     * A method to output the random lotto numbers and user's numbers.
     * 
     * @param lottoNumbers randomly generated lotto numbers
     * @param userNumbers  user selected numbers
     */
    private static void outputNumbers(int[] lottoNumbers, int[] userNumbers) {
        System.out.print("User lotto:   ");
        int[] sortedUserNumbers = MyArrays.sort(userNumbers);
        MyArrays.printWithPrefix(sortedUserNumbers, '0', 1); // [01, 02, 03, 04, 05, 06, 07]
        System.out.print("Random lotto: ");
        int[] sortedLottoNumbers = MyArrays.sort(lottoNumbers);
        MyArrays.printWithPrefix(sortedLottoNumbers, '0', 1);
    }

}