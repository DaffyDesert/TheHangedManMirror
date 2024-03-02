import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private JLabel hiddenWord;
    private JLabel wrongLetters;
    private JLabel wrongWords;

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

        // FIXME: No drawing yet, for now will be text so you know it goes there
        JLabel drawingLabel = new JLabel("DRAWING WILL GO HERE");
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

        JTextField guessField = new JTextField(20);

        JPanel buttonPanel = new JPanel();
        JButton letterButton = new JButton("Guess Letter");
        JButton wordButton = new JButton("Guess Word");

        buttonPanel.add(letterButton);
        buttonPanel.add(wordButton);

        tempPanel.add(guessField);
        tempPanel.add(buttonPanel);

        return tempPanel;
    }

    // add event listener for both buttons

    public void runGameRound() {
        // Create instance of a game
        newGame = new RegularGameplayLogic();
        newGame.startGame();

        System.out.println("Pulling from game " + newGame.getTargetWord());

        // Set up and adjust screen elements
        updateGameGraphics();

        // Loops, waiting on input
        boolean isGameComplete = false;
        int i = 0; // temp
        while (!isGameComplete) {
            System.out.println("Round " + i);
            i++;

            if (i == 2) {
                isGameComplete = true;
            }
        }
        System.out.println("out of while loop");
    }

    // includes image, wrong guess, right guess?
    private void updateGameGraphics() {
        // Update hidden word with all guessed letters

        // Updates guessing word with all the blanks filled in
        String knownWord = "";
        for (int i = 0; i < newGame.getTargetWord().length(); i++) {
            if (newGame.getGuessStatus().get(i).compareTo("") == 0) {
                knownWord += "_ ";
            } else {
                knownWord += newGame.getGuessStatus().get(i) + " ";
            }
        }
        hiddenWord.setText(knownWord);

        // Lists out all of the failed letter guesses
        String incorrectLetters = "";
        for (int i = 0; i < newGame.getIncorrectLetterGuesses().size(); i++) {
            incorrectLetters += newGame.getIncorrectLetterGuesses().get(i) + " ";
        }
        wrongLetters.setText("Incorrect Letters: " + incorrectLetters);

        // Lists out all of the failed word guesses
        String incorrectWords = "";
        for (int i = 0; i < newGame.getGuessedWords().size(); i++) {
            incorrectWords += newGame.getGuessedWords().get(i) + " ";
        }
        wrongWords.setText("Incorrect Words" + incorrectWords);

        // Update Image
        // FIXME
    }

    // press letter button
    private void letterButton() {
        // validate
        // has used before
        // is correct
    }

    // press word button
    // copy from letter button
}