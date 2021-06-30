package com.example.mypackage;

import javax.swing.*;
import java.util.Random;

public class BullsandCows {

    public static final Random RANDOM = new Random();
    private String number;// number to find
    private int nbGuesses;
    private static String result =" ";

    //private String guess; //number user

   // JFrame frame = new JFrame("Input Dialog");

    // we need a method to generate the number to find
    public String generateNumber() {
        do {
            number = String.valueOf(RANDOM.nextInt(9000) + 1000);//4 digit number
        } while (hasDuplicates(number));// we need to have 4 digit number with no duplicated

        System.out.println("[CHEAT] = " + number + "\n");
        return number;

    }

    public boolean hasDuplicates(String number) {
        int num = Integer.valueOf(number);
        boolean[] digits = new boolean[10];
        while (num > 0) {
            int last = num % 10;
            if (digits[last])
                return true;
            digits[last] = true;
            num = num / 10;
        }
        return false;
    }

    public String bullsAndCows(String entered) {
        int bulls = 0;
        int cows = 0;

        String enteredStr = String.valueOf(entered);
        String numberStr = String.valueOf(number);

        for (int i = 0; i < numberStr.length(); i++) {
            char c = enteredStr.charAt(i);

            if (c == numberStr.charAt(i)) {
                bulls++;
            } else if (numberStr.contains(String.valueOf(c))) {
                cows++;
            }
        }
        //increment the count of his guess(user)
        nbGuesses++;

        result +="Guess#" + nbGuesses + ": " + entered + " Bulls " + bulls + " Cows " + cows +"\n";

        return result;
    }

    public String goodGuess(String oldGuess, JFrame frame) {
        boolean isDigit = true;
        if (oldGuess == null) {
            return null;
        }

        // isDigit = false if user insert non digit value
        try {
            Integer.parseInt(oldGuess);
        } catch (NumberFormatException ex) {
            isDigit = false;
        }

        String newGuess = oldGuess;
        if (!isDigit || oldGuess.length() != 4 || hasDuplicates(oldGuess)) {
            newGuess = JOptionPane.showInputDialog(frame,
                    "Please enter a 4 digit number.\n Different digits.",
                    "INVALID NUMBER!!!", JOptionPane.ERROR_MESSAGE);
            goodGuess(newGuess, frame);
        }
        return newGuess;
    }

}
