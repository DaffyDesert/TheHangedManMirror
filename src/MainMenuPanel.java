import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainMenuPanel extends JPanel {

    public static final String NAME = "MAIN";

    private CardLayout cLayout;
    private JPanel buttonScreens;
    private JPanel howToPlayPanel;

    private JButton easyButton, mediumButton, hardButton, extremeButton, arcadeButton, backButton, playButton, howToButton, customButton, quitButton;

    private enum ButtonValues {
        PLAY, HOWTO, CUSTOM, QUIT, ARCADE, BACK
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

        // Create the How To Play panel and add it to the buttonScreens
        howToPlayPanel = createHowToPlayPanel();
        buttonScreens.add(howToPlayPanel, "HOWTO_SCREEN");

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
        howToButton = new JButton("How To Play");
        customButton = new JButton("Customization Menu");
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
        arcadeButton = new JButton("Arcade Mode");
        backButton = new JButton("Back to Main Menu");

        arcadeButton.addActionListener(e -> buttonClicked(ButtonValues.ARCADE));
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

    /**
     * Creates a JPanel containing instructions on how to play the game
     */
    private JPanel createHowToPlayPanel() {
        JPanel tempPanel = new JPanel();
        
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
    // Load custom font
        Font customFont = loadCustomFont("res/Alice_in_Wonderland_3.ttf", 25f);
        if (customFont != null) {
            textArea.setFont(customFont);
        }
    
        JScrollPane scrollPane = new JScrollPane(textArea);
    
        tempPanel.setLayout(new BorderLayout());
    
        JPanel buttonPanel = new JPanel();
        JButton backButton = new JButton("Back to Main Menu");
        JButton quitButton = new JButton("Quit Game");
    
        backButton.addActionListener(e -> buttonClicked(ButtonValues.BACK));
        quitButton.addActionListener(e -> buttonClicked(ButtonValues.QUIT));
    
        buttonPanel.add(backButton);
        buttonPanel.add(quitButton);
    
        //tempPanel.add(new JLabel("How to Play the Game"), BorderLayout.NORTH);
        tempPanel.add(scrollPane, BorderLayout.CENTER);
        tempPanel.add(buttonPanel, BorderLayout.SOUTH);
    
        return tempPanel;
    }
    
    private void buttonClicked(ButtonValues buttonValue) {
        switch (buttonValue) {
            case PLAY:
                cLayout.show(buttonScreens, "MODE_BUTTONS");
                break;
            case HOWTO:
                cLayout.show(buttonScreens, "HOWTO_SCREEN");
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

    private Font loadCustomFont(String fontPath, float fontSize) {
    try {
        Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(fontSize);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(customFont);
        return customFont;
    } catch (IOException | FontFormatException e) {
        e.printStackTrace();
        // Handle font loading errors here
        return null;
    }
}
}
