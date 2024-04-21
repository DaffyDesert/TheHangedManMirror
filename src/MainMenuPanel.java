import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {

    public static final String NAME = "MAIN";

    private CardLayout cLayout;
    private JPanel buttonScreens;

    private JButton easyButton, mediumButton, hardButton, extremeButton, arcadeButton, backButton, playButton, howToButton, customButton, quitButton;

    private enum ButtonValues {
        PLAY, HOWTO, CUSTOM, QUIT, BACK
    }

    private MainGUI myMain;

    public MainMenuPanel(MainGUI mainPass) {
        myMain = mainPass;
        JPanel tempPanel = new JPanel();
        GridLayout tempLayout = new GridLayout(1, 2);
        tempLayout.setHgap(25);
        tempPanel.setLayout(tempLayout);

        tempPanel.add(createDrawingPanel());

        buttonScreens = new JPanel();
        cLayout = new CardLayout();
        buttonScreens.setLayout(cLayout);
        tempPanel.add(buttonScreens);

        buttonScreens.add(createButtonPanel(), "MAIN_BUTTONS");
        buttonScreens.add(createGameModeButtons(), "MODE_BUTTONS");

        add(tempPanel);
    }

    /*
     * Creates a JPanel containing the title and image for the game
     */
    private JPanel createDrawingPanel() {
        JPanel tempPanel = new JPanel();

        Box box = Box.createVerticalBox();

        JLabel titleLabel = new JLabel("The Hanged Man:");
        JLabel subTitleLabel = new JLabel("A Hangman Experience");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        subTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel drawingLabel = new JLabel();
        drawingLabel.setIcon(new ImageIcon("res/images/hangman-011.png"));
        drawingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        box.add(titleLabel);
        box.add(subTitleLabel);
        box.add(drawingLabel);

        tempPanel.add(box, BorderLayout.CENTER);

        return tempPanel;
    }

    /*
     * Creates a JPanel containing all of the initial menu buttons
     */
    private JPanel createButtonPanel() {
        JPanel tempPanel = new JPanel();
        GridLayout tempLayout = new GridLayout(6, 1);
        tempLayout.setVgap(80);
        tempPanel.setLayout(tempLayout);

        playButton = new JButton("Play The Hanged Man");
        howToButton = new JButton(new ChangeToAction("How To Play", HowToPanel.NAME, myMain));
        customButton = new JButton(new ChangeToAction("Customization Menu", CustomPanel.NAME, myMain));
        quitButton = new JButton("Quit Game");

        playButton.addActionListener(e -> buttonClicked(ButtonValues.PLAY));
        howToButton.addActionListener(e -> buttonClicked(ButtonValues.HOWTO));
        customButton.addActionListener(e -> buttonClicked(ButtonValues.CUSTOM));
        quitButton.addActionListener(e -> buttonClicked(ButtonValues.QUIT));

        tempPanel.add(new JLabel(""));
        tempPanel.add(playButton);
        tempPanel.add(howToButton);
        tempPanel.add(customButton);
        tempPanel.add(quitButton);
        tempPanel.add(new JLabel(""));

        return tempPanel;
    }

    /**
     * Creates a JPanel with all of the game mode buttons
     */
    private JPanel createGameModeButtons() {
        JPanel tempPanel = new JPanel();
        GridLayout tempLayout = new GridLayout(8, 1);
        tempLayout.setVgap(60);
        tempPanel.setLayout(tempLayout);

        easyButton =  new JButton(new ChangeToAction("Easy Mode", GamePanel.NAME, myMain, GameDifficulty.EASY));
        mediumButton = new JButton(new ChangeToAction("Medium Mode", GamePanel.NAME, myMain, GameDifficulty.MEDIUM));
        hardButton = new JButton(new ChangeToAction("Hard Mode", GamePanel.NAME, myMain, GameDifficulty.HARD));
        extremeButton = new JButton(new ChangeToAction("Extreme Mode", GamePanel.NAME, myMain, GameDifficulty.ALL));
        arcadeButton = new JButton(new ChangeToAction("Arcade Mode", GamePanel.NAME, myMain, GameDifficulty.ARCADE));
        backButton = new JButton("Back to Main Menu");

        backButton.addActionListener(e -> buttonClicked(ButtonValues.BACK));

        tempPanel.add(new JLabel(""));
        tempPanel.add(easyButton);
        tempPanel.add(mediumButton);
        tempPanel.add(hardButton);
        tempPanel.add(extremeButton);
        tempPanel.add(arcadeButton);
        tempPanel.add(backButton);
        tempPanel.add(new JLabel(""));

        return tempPanel;
    }
    
    private void buttonClicked(ButtonValues buttonValue) {
        switch (buttonValue) {
            case PLAY:
                cLayout.show(buttonScreens, "MODE_BUTTONS");
                break;
            case CUSTOM:
                System.out.println("Pressed custom:: Not Yet Implemented");
                break;
            case QUIT:
                System.exit(0);
                break;
            case ARCADE:
                System.out.println("Pressed arcade:: Not Yet Implemented");
                break;
            case BACK: 

                cLayout.show(buttonScreens, "MAIN_BUTTONS");
                break;
        }
    }

    public void correctScreenDisplay() {
        cLayout.show(buttonScreens, "MAIN_BUTTONS");
    }
}
