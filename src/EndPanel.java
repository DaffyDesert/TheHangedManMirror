import java.awt.*;
import javax.swing.*;

public class EndPanel extends JPanel {

    public static final String NAME = "END";

    private JLabel statusLabel, wordLabel;

    private MainGUI myMain;

    public EndPanel(MainGUI mainPass) {
        myMain = mainPass;
        
        setLayout(new BorderLayout());

        Box box = Box.createVerticalBox();
        box.add(createStatusPanel());
        box.add(createButtonPanel());

        add(box, BorderLayout.CENTER);
    }

    /*
     * Creates the JPanel containing the game results.
     */
    private JPanel createStatusPanel() {
        JPanel statusPanel = new JPanel(new GridLayout(2, 1));

        statusLabel = new JLabel();
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        wordLabel = new JLabel();
        wordLabel.setHorizontalAlignment(SwingConstants.CENTER);

        statusPanel.add(statusLabel);
        statusPanel.add(wordLabel);

        return statusPanel;
    }

    /*
     * Creates the JPanel containing the user buttons.
     */
    private JPanel createButtonPanel() {
        JPanel statusPanel = new JPanel();

        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(e -> quitButtonClicked());
        JButton againButton = new JButton("Play Again?");
        //againButton.addActionListener(e -> againButtonClicked());

        statusPanel.add(quitButton);
        statusPanel.add(againButton);

        return statusPanel;
    }

    /*
     * Called when the quitButton is pressed.
     * Quits out the game
     */
    private void quitButtonClicked() {
        System.exit(0);
    }

    /*
     * Receives the game stats from the
     * player's game through parameters.
     * Uses these parameters to customize what
     * is displayed to the user.
     */
    public void parseGameStats(String[] gameInformation) {
        System.out.println("the game is " + gameInformation[0]);
        System.out.println("the word was " + gameInformation[1]);
        /* 
        if (isGameWon) {
            statusLabel.setText("You won!");
        } else {
            statusLabel.setText("You lost.");
        }
        wordLabel.setText("The word was: " + targetWord);*/
    }
}