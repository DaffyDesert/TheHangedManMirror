import javax.swing.*;

import java.awt.*;

public class GamePanel extends JPanel {

    public static final String NAME = "GAME";

    private JLabel hiddenWord, wrongLetters, wrongWords, drawingLabel, errorLabel;

    private JTextField guessField;

    private RegularGameplayLogic newGame;

    private MainGUI myMain;

    public GamePanel(MainGUI mainPass) {
        myMain = mainPass;
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

        runGameRound();
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
        tempPanel.setLayout(new GridLayout(4, 1));

        guessField = new JTextField(20);

        JPanel buttonPanel = new JPanel();

        JButton letterButton = new JButton("Guess Letter");
        letterButton.addActionListener(e -> letterButtonClicked());

        JButton wordButton = new JButton("Guess Word");
        wordButton.addActionListener(e -> wordButtonClicked());

        errorLabel = new JLabel();
        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        errorLabel.setVerticalAlignment(SwingConstants.NORTH);

        buttonPanel.add(letterButton);
        buttonPanel.add(wordButton);

        tempPanel.add(guessField);
        tempPanel.add(buttonPanel);
        tempPanel.add(errorLabel);

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

        String imagePath = "res/images/hangman-0" + newGame.getNumIncorrectGuessesMade() + ".png";
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
        String userInput = new String(guessField.getText());
        userInput.toUpperCase();
        if (newGame.isValidLetterGuess(userInput)) {
            if (!newGame.hasGuessedLetterBefore(userInput)) {
                if (newGame.isCorrectLetterGuess(userInput)) {
                    errorLabel.setText("Correct letter guess.");
                } else {
                    errorLabel.setText("Incorrect letter guess, penalty.");
                }
            } else {
                errorLabel.setText("You have guessed the letter \'" + userInput + "\' before, no penalty.");
            }
        } else {
            errorLabel.setText("Your input \'" + userInput + "\' is not valid for a letter guess, no penalty.");
        }

        checkGameOver();
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
                    errorLabel.setText("Correct word guess.");
                } else {
                    errorLabel.setText("Incorrect word guess, penalty.");
                }
            } else {
                errorLabel.setText("You have guessed the word \'" + userInput + "\' before, no penalty.");
            }
        } else {
            errorLabel.setText("Your input \'" + userInput + "\' is not valid for a word guess, no penalty.");
        }
        
        checkGameOver();
    }

    public void cleanUp() {
        hiddenWord.setText("");
        wrongLetters.setText("");
        wrongWords.setText("");
        drawingLabel.setIcon(null);
        errorLabel.setText("");
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

    public void checkGameOver() {
        updateGameGraphics();
        if(newGame.isGameOver()) {
            System.out.println("should clean up screen and wait");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            cleanUp();
            myMain.showCard(EndPanel.NAME);
        }
        
    }
}