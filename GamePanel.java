import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public GamePanel() {
        setLayout(new GridLayout(1, 2));

        JPanel leftPanel = new JPanel();
        leftPanel.add(createDrawingPanel());

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(3, 1));
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

        JLabel hiddenWord = new JLabel("*******");
        hiddenWord.setHorizontalAlignment(JLabel.CENTER);
        tempPanel.add(hiddenWord, BorderLayout.SOUTH);

        return tempPanel;
    }

    private JPanel createWrongPanel() {
        JPanel tempPanel = new JPanel();
        tempPanel.setLayout(new BorderLayout());

        JLabel wrongLetters = new JLabel("WRONG LETTERS: ");
        wrongLetters.setHorizontalAlignment(JLabel.CENTER);
        tempPanel.add(wrongLetters, BorderLayout.CENTER);

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
}