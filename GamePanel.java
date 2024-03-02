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

    private JPanel createDrawingPanel() {
        JPanel tempPanel = new JPanel();

        drawingLabel = new JLabel();
        tempPanel.add(drawingLabel);

        return tempPanel;
    }

    private JPanel createHiddenPanel() {
        JPanel tempPanel = new JPanel();
        tempPanel.setLayout(new BorderLayout());

        hiddenWord = new JLabel("*******");
        hiddenWord.setHorizontalAlignment(JLabel.CENTER);
        tempPanel.add(hiddenWord, BorderLayout.CENTER);

        return tempPanel;
    }

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

    public void runGameRound() {
        // Create instance of a game
        newGame = new RegularGameplayLogic();
        newGame.startGame();

        System.out.println("Pulling from game " + newGame.getTargetWord());

        // Set up and adjust screen elements
        updateGameGraphics();
    }

    // includes image, wrong guess, right guess?
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

    public boolean checkGameOver() {
        return newGame.isGameOver();
    }

    public boolean checkGameWin() {
        return newGame.isGameWon();
    }

    private void letterButtonClicked() {
        // Pull the word from the textfield
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
}