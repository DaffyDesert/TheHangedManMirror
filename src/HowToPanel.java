import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class HowToPanel extends JPanel {

    public static final String NAME = "HOWTO";

    private MainGUI myMain;

    private AudioPlayerInterface AudioPlayer;

    public HowToPanel(MainGUI mainPass) {
        myMain = mainPass;

        AudioPlayer = new AudioPlayer();

        setLayout(new BorderLayout());
        
        add(createHowToPlayPanel(), BorderLayout.CENTER);
    }

    /**
     * Creates a JPanel containing instructions on how to play the game
     */
    private JPanel createHowToPlayPanel() {
        JPanel tempPanel = new JPanel();
        tempPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JTextArea textArea = new JTextArea("Game Objective:\r\n" + //
                        "Guess the word correctly before the hangman is fully drawn.\r\n\n" + //
                        "How To Play:\r\n" + //
                        "Pick your choice of difficulty to begin playing.\r\n" + //
                        "A word is randomly selected, and your goal is to guess it letter by letter.\r\n" + //
                        "Guess the entire word or letters one at a time. If the guess is correct, it will be revealed. If not, a part of the hangman is drawn.\r\n" + //
                        "Keep guessing until you either guess the word correctly or the hangman is fully drawn.\r\n\n" + //
                        "Features:\r\n" + //
                        " -Difficulty Levels: Choose from a range of difficulty levels, from novice to expert.\r\n" + //
                        "   -The Fool: less than 6 letters per word\r\n" + //
                        "   -Strength: 6 - 8 letters per word with at least one\r\n" + //
                        "    letter repeated\r\n" + //
                        "   -Death: 7+ letters per word with no more than 1\r\n" + //
                        "    letter repeated more than once\r\n" + //
                        "   -The World: Every word in the dictionary is possible.\r\n" + //
                        " -Themes: Immerse yourself in various themes that bring a fresh aesthetic to the classic gameplay.\r\n" + //
                        " -Sound Effects: Let the sound effects heighten the tension as you race to victory.\r\n" + //
                        "");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
    
        JScrollPane scrollPane = new JScrollPane(textArea);
    
        tempPanel.setLayout(new BorderLayout());
    
        JPanel buttonPanel = new JPanel();
        JButton backButton = new JButton(new ChangeToAction("Back to Main Menu", MainMenuPanel.NAME, myMain));
        
        backButton.addActionListener(e -> buttonClicked());

        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AudioPlayer.buttonHover();
            }
        });

        buttonPanel.add(backButton);
    
        tempPanel.add(scrollPane, BorderLayout.CENTER);
        tempPanel.add(buttonPanel, BorderLayout.SOUTH);
    
        return tempPanel;
    }
    
    /*
     * Plays button select sound on any other button selected.
     */
    private void buttonClicked() {
        AudioPlayer.buttonClick();
    }
}