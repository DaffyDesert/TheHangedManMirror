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

        
        JButton againButton = new JButton(new ChangeToAction("Play Again", GamePanel.NAME, myMain));
        JButton menuButton =  new JButton(new ChangeToAction("Return to Menu", MainMenuPanel.NAME, myMain));
        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(e -> quitButtonClicked());
        
        statusPanel.add(againButton);
        statusPanel.add(menuButton);
        statusPanel.add(quitButton);
        

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
     * Takes in the game stats as an array,
     * assigning temp variables with these values and
     * using them to create the game stats display
     * information.
     */
    public void parseGameStats(String[] gameInformation) {
        boolean isGameWon = Boolean.parseBoolean(gameInformation[0]);
        String gameWord = gameInformation[1];
        
        if (isGameWon) {
            statusLabel.setText("You won!");
        } else {
            statusLabel.setText("You lost.");
        }
        wordLabel.setText("The word was: " + gameWord);
    }
}