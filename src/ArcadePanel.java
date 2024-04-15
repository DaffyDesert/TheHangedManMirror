import java.awt.*;
import javax.swing.*;

public class ArcadePanel extends JPanel{
    public static final String NAME = "ARCADE";

    private JLabel statusLabel, pointsLabel, wordLabel;

    private MainGUI myMain;
    private ChangeToAction againAction;

    public ArcadePanel(MainGUI mainPass) {
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
        JPanel statusPanel = new JPanel(new GridLayout(3, 1));

        statusLabel = new JLabel();
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        pointsLabel = new JLabel();
        pointsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        wordLabel = new JLabel();
        wordLabel.setHorizontalAlignment(SwingConstants.CENTER);

        statusPanel.add(statusLabel);
        statusPanel.add(pointsLabel);
        statusPanel.add(wordLabel);

        return statusPanel;
    }

    /*
     * Creates the JPanel containing the user buttons.
     */
    private JPanel createButtonPanel() {
        JPanel statusPanel = new JPanel();

        againAction = new ChangeToAction("Continue", GamePanel.NAME, myMain, GameDifficulty.ARCADE);
        JButton againButton = new JButton(againAction);
        
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
        String pointsValue = gameInformation[2];
        String gameDifficulty = gameInformation[3];
        againAction.setDifficulty(gameDifficulty);
        
        statusLabel.setText("Level Successfully Completed!");  
       
        pointsLabel.setText("Total Points: " + pointsValue);
        wordLabel.setText("The word was: " + gameWord);
    }
}
