package com.github.zipcodewilmington;


import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */

public class Hangman{
    public static void main(String[] args) {
        main1();
    }
    public static void main1() {
        String randomWord = getRandomWord(wordList());
        int numberOfGuesses = getNumberOfTries(randomWord);
        String[] updatedGuessArray = getBlankString(randomWord, numberOfGuesses);

        for (int i = 0; i < numberOfGuesses; i++) {
            System.out.println("You have " + (numberOfGuesses - i) + "letter guesses remaining.");
            String guessedChar = getGuessChar();
            for (int k = 0; k < numberOfGuesses; k++) {
                if (guessedChar.equals(randomWord.split("")[k])) {
                    updatedGuessArray[k] = guessedChar;
                }
            }
            System.out.println("Current Guess: " + Arrays.toString(updatedGuessArray));
        }
        System.out.println("Please guess the word, this is your last chance!");
        Scanner scan = new Scanner(System.in);
        String guessWord = scan.nextLine();
        if (guessWord.equals(randomWord)) {
            System.out.println("Congratulations! You got the correct word!");
        } else {
            System.out.println("Uh oh! Better luck next time!");
        }
        doAgain();
    }

    public static void doAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to play again? Press 'y' for yes, 'n' for no.");
        String response = scanner.nextLine();
        if (response.equals("y")) main1();
    }

    private static String[] getBlankString(String randomWord, int numberOfGuesses) {
        String[] updatedGuessArray = new String[numberOfGuesses];
        System.out.println("Word to be guessed: " + randomWord);
        for (int j = 0; j < numberOfGuesses; j++) {
            updatedGuessArray[j] = "-";
        }
        return updatedGuessArray;
    }

    public static String[] wordList() {
        String[] wordList = {"boggle", "cobweb", "duplex", "galaxy", "khaki", "disavow", "cycle", "injury", "pneumonia", "pajama"};
        return wordList;
    }

    public static String getRandomWord(String[] wordList){
        int i = (int) Math.floor(Math.random()*wordList.length);
        return wordList[i];
    }

    public static int getNumberOfTries(String guessingWord) {
        int numberOfTries = guessingWord.length();
        return numberOfTries;
    }

    public static String getGuessChar() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please guess a letter in the word: ");
        String guessChar = in.nextLine();
        return guessChar;


//        int count = 0;
//        String[] words = {"boggle", "cobweb", "duplex", "galaxy", "khaki", "disavow", "cycle", "injury", "pneumonia", "pajama"};
//        String word = words[(int)(Math.random()*words.length())]

        }
        }

