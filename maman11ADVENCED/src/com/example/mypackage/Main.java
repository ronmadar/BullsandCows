package com.example.mypackage;

import javax.swing.*;
import java.util.Scanner;

import static java.lang.System.exit;


public class Main {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //Custom button text
        Object[] options = {"OK", "Cancel"};
        int gameDescription = JOptionPane.showOptionDialog(null,
                "Hello everybody and Welcome to game Bulls to target number!\n\n" +

                        " the goal is will find the secret number Four-digit by guessing.\n\n" +

                        " there are some rules:\n" +
                        "- you need to guss 4 digit in number, that the game bring us\n" +
                        "- The exact number of vulnerabilities is marked guess right- it is mean in the right position\n" +
                        "- The number of digits that appear In the original number but elsewhere. marked half right\n\n" +

                        "Click Ok to begin the game and enjoy",
                "Hitting the target", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (gameDescription == 0) {
            while (true) {
                int countTitle = startGame();
                if (!succeed(countTitle)) {
                    endGame();
                }
            }

        } else { // cancel play
            endGame();
        }



// -------------------------------------------------------------------------------------------------

        System.out.println("Please enter the numerator");
        int numer = input.nextInt();
        System.out.println("Please enter the denominator");
        int denom = input.nextInt();


        Rational test1 = new Rational(numer, denom);
        Rational test2 = new Rational(1, 3);
        Rational test3 = new Rational(1, 8);
        Rational test4 = new Rational(1, 2);

        System.out.println(test1.greaterThan(test2));
        System.out.println("--------greaterThan-------------------------------------------------------------------------");

        System.out.println(test1.equals(test2));
        System.out.println("--------equals-------------------------------------------------------------------------");

        System.out.println(test1.plus(test3));
        System.out.println("--------plus-------------------------------------------------------------------------");

        System.out.println(test1.minus(test4));
        System.out.println("---------minus------------------------------------------------------------------------");

        System.out.println(test1.multiplay(test2));
        System.out.println("-----------multiplay----------------------------------------------------------------------");

        System.out.println(test1.getDenominatorQ());
        System.out.println("-----------getDenominatorQ----------------------------------------------------------------------");

        System.out.println(test1.getNumeratorP());
        System.out.println("----------getNumeratorP-----------------------------------------------------------------------");

        System.out.println(test1.toString());
        System.out.println("-------toString--------------------------------------------------------------------------");


        Rational test5 = new Rational(42, 5);
        System.out.println("test5 " + test5);
        System.out.println("-------reduce--------------------------------------------------------------------------");
        test5.reduce();
        System.out.println("test5 " + test5);


    }//End of main.

    private static int startGame() {
        System.out.println("inside startGame");
        BullsandCows bullSandCows = new BullsandCows();
        String number = bullSandCows.generateNumber();

        int countTitle = 1;
        String guess;

        guess = JOptionPane.showInputDialog(null,
                "Please enter your guess",
                "Guess #" + countTitle,
                JOptionPane.PLAIN_MESSAGE);

        while (true) {
            // invalid cases
            guess = bullSandCows.goodGuess(guess, null);

            if (guess == null) {
                // abort the game
                endGame();
                return countTitle;
            }

            if (number.equals(guess)) {
                // win the game
                return countTitle;
            } else {
                //increment the count title of the panel
                countTitle++;
                guess = JOptionPane.showInputDialog(null,
                        bullSandCows.bullsAndCows(guess) + "\n" +
                                "Please enter your next guess:",
                        "Guess# " + countTitle,
                        JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    private static boolean succeed(int countTitle) {
        System.out.println("succeed");
        Object[] options = {"YES", "No"};
        int buttons = JOptionPane.showOptionDialog(null,
                "well done! you success found the number in " + countTitle + " attempt" + "\n\n" +
                        "hey :)\n" +
                        "Do you want to play again??",
                "You Won!", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (buttons == 1 || buttons == -1) {
            return false;
        } else {
            System.out.println("startGame");
            // start a new game
            return true;
        }
    }

    private static void endGame() {
        JOptionPane.showMessageDialog(null, "thanks for playing",
                "see you soon..",
                JOptionPane.INFORMATION_MESSAGE);
        exit(0);
    }

}//End of class.




