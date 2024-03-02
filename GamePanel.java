import javax.swing.*;

import java.awt.*;

public class GamePanel extends JPanel {

    private JLabel hiddenWord;
    private JLabel wrongLetters;
    private JLabel wrongWords;
    private JTextField guessField;
    private JLabel drawingLabel;

    private RegularGameplayLogic newGame;

    public GamePanel() {
        setLayout(new GridLayout(1, 2));

        JPanel leftPanel = new JPanel();
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        leftPanel.add(createDrawingPanel());

        JPanel rightPanel = new JPanel();
        rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridLayout rightLayout = new GridLayout(3, 1);
        rightPanel.setLayout(rightLayout);
        rightPanel.add(createHiddenPanel());
        rightPanel.add(createWrongPanel());
        rightPanel.add(createGuessingPanel());

        add(leftPanel);
        add(rightPanel);
    }

    /*
     * Creates the JPanel containing the hangman image.
     */
    private JPanel createDrawingPanel() {
        JPanel tempPanel = new JPanel();

        drawingLabel = new JLabel();
        tempPanel.add(drawingLabel);

        return tempPanel;
    }

    /*
     * Creates the JPanel containing the hidden/target word.
     */
    private JPanel createHiddenPanel() {
        JPanel tempPanel = new JPanel();
        tempPanel.setLayout(new BorderLayout());

        hiddenWord = new JLabel("*******");
        hiddenWord.setHorizontalAlignment(JLabel.CENTER);
        tempPanel.add(hiddenWord, BorderLayout.CENTER);

        return tempPanel;
    }

    /*
     * Creates the JPanel containing all the incorrect word/letter guesses.
     */
    private JPanel createWrongPanel() {
        JPanel tempPanel = new JPanel();
        BorderLayout tempLayout = new BorderLayout(20, 20);
        tempPanel.setLayout(tempLayout);

        wrongLetters = new JLabel();
        wrongLetters.setHorizontalAlignment(JLabel.CENTER);

        wrongWords = new JLabel();
        wrongWords.setHorizontalAlignment(JLabel.CENTER);

        tempPanel.add(wrongLetters, BorderLayout.NORTH);
        tempPanel.add(wrongWords, BorderLayout.CENTER);

        return tempPanel;
    }

    /*
     * Creates the JPanel containing the user input field and buttons.
     */
    private JPanel createGuessingPanel() {
        JPanel tempPanel = new JPanel();
        tempPanel.setLayout(new GridLayout(2, 1));

        guessField = new JTextField(20);

        JPanel buttonPanel = new JPanel();

        JButton letterButton = new JButton("Guess Letter");
        letterButton.addActionListener(e -> letterButtonClicked());

        JButton wordButton = new JButton("Guess Word");
        wordButton.addActionListener(e -> wordButtonClicked());

        buttonPanel.add(letterButton);
        buttonPanel.add(wordButton);

        tempPanel.add(guessField);
        tempPanel.add(buttonPanel);

        return tempPanel;
    }

    /*
     * Starts a round of the game using the game logic.
     * Calls updateGameGraphics() to ensure screen
     * shows the game round specific graphics.
     */
    public void runGameRound() {
        newGame = new RegularGameplayLogic();
        newGame.startGame();

        // FIXME: Can be removed, used for testing/
        System.out.println("Pulling from game: " + newGame.getTargetWord());

        updateGameGraphics();
    }

    /*
     * Updates the game graphics to reflect updated incorrect and correct guesses.
     * This includes: the hangman image, hidden word, incorrect letter/word bank
     * as applicable.
     */
    private void updateGameGraphics() {
        String knownWord = "";
        for (int i = 0; i < newGame.getTargetWord().length(); i++) {
            if (newGame.getGuessStatus().get(i).compareTo("") == 0) {
                knownWord += "_ ";
            } else {
                knownWord += newGame.getGuessStatus().get(i).toUpperCase() + " ";
            }
        }
        hiddenWord.setText(knownWord);

        String incorrectLetters = "";
        for (int i = 0; i < newGame.getIncorrectLetterGuesses().size(); i++) {
            incorrectLetters += newGame.getIncorrectLetterGuesses().get(i) + " ";
        }
        wrongLetters.setText("Incorrect Letters: " + incorrectLetters);

        String incorrectWords = "";
        for (int i = 0; i < newGame.getGuessedWords().size(); i++) {
            if (!(newGame.getGuessedWords().get(i).compareToIgnoreCase(newGame.getTargetWord()) == 0)) {
                incorrectWords += newGame.getGuessedWords().get(i) + " ";
            }
        }
        wrongWords.setText("Incorrect Words: " + incorrectWords);

        System.out.println("number of incorrect guesses is: " + newGame.getNumIncorrectGuessesMade());
        String imagePath = "images/hangman-0" + newGame.getNumIncorrectGuessesMade() + ".png";
        drawingLabel.setIcon(new ImageIcon(imagePath));

        guessField.setText("");
    }

    /*
     * Called when the letterButton is pressed.
     * Takes in the guessField's first letter input, checking
     * that it is a valid letter guess, hasn't been guessed
     * before, and is a correct letter guess.
     * Calls the updateGameGraphics() to change the
     * graphics to reflect the user guess.
     */
    private void letterButtonClicked() {
        String userInput = new String(guessField.getText().charAt(0) + "");
        userInput.toUpperCase();
        if (newGame.isValidLetterGuess(userInput)) {
            if (!newGame.hasGuessedLetterBefore(userInput)) {
                if (newGame.isCorrectLetterGuess(userInput)) {
                    System.out.println("Correct letter guess.");
                } else {
                    System.out.println("Incorrect letter guess, penalty.");
                }
            } else {
                System.out.println("You have guessed this letter before, no penalty.");
            }
        } else {
            System.out.println("Your input is not valid for a letter guess, no penalty.");
        }
        updateGameGraphics();
    }

    /*
     * Called when the worddButton is pressed.
     * Takes in the guessField's string, checking
     * that it is a valid word guess, hasn't been guessed
     * before, and is the correct word guess.
     * Calls the updateGameGraphics() to change the graphics
     * to reflect the user guess.
     */
    private void wordButtonClicked() {
        String userInput = new String(guessField.getText());
        userInput.toUpperCase();
        if (newGame.isValidWordGuess(userInput)) {
            if (!newGame.hasGuessedWordBefore(userInput)) {
                if (newGame.isCorrectWordGuess(userInput)) {
                    System.out.println("Correct word guess.");
                } else {
                    System.out.println("Incorrect word guess, penalty.");
                }
            } else {
                System.out.println("You have guessed this word before, no penalty.");
            }
        } else {
            System.out.println("Your input is not valid for a word guess, no penalty.");
        }
        updateGameGraphics();
    }

    public boolean isGameOver() {
        return newGame.isGameOver();
    }

    public boolean isGameWon() {
        return newGame.isGameWon();
    }

    public String getTargetWord() {
        return newGame.getTargetWord();
    }
}