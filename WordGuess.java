import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * File Name: WordGuess.java
 * Purpose:
 *  The purpose of the WordGues class file is to
 *  handle the logic required for the user to be able to guess what
 *  the entire word is in a game of hangman, instead of attempting to guess
 *  a single letter.
 */

 public class WordGuess {

    
    public WordGuess(String chosenWord, int numGuesses) {
        this.chosenWord = chosenWord;
        this.uScanner = new Scanner(System.in);
        this.numGuesses = numGuesses;
    }

    //prompt the user for input, and check if the input is legal.
    public void askUser() {
        String nameBlanks = "";

        for(int i = 0; i < this.chosenWord.length(); ++i) {
            nameBlanks += "_";
        }

        while(numGuesses > 0) {
            System.out.println(nameBlanks);
            System.out.println("What is the word?");

            this.userInput = this.uScanner.nextLine();

            if(!isLegal(userInput)) {
                System.err.println("Invalid input!");
                break;
            }

            else if(userInput.equalsIgnoreCase(chosenWord)) {
                System.out.println("Correct! The word is " + chosenWord);
                break;
            }
            else {
                    --numGuesses;

                    if(numGuesses > 0) {
                        System.out.println("Nope! " + userInput + " isnt it! Try again.");
                    }
                    else {
                        System.out.println("Nope! " + userInput + " isnt it! " + chosenWord + " was the answer. You Lose >:)");
                        break;
                    }
            }
        }

        uScanner.close();
    }
    
    private static boolean isLegal(String str) {
        // Regular expression to match only English alphabetic characters
        Pattern pattern = Pattern.compile("^[a-zA-Z]*$");
        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
    }
    
    private String chosenWord;  //storage for the word that the player needs to guess.
    private Scanner uScanner;
    private String userInput;   //sotres the users guess
    private int numGuesses;     //how many attempts the user gets.

 }