import javax.swing.*;

import com.formdev.flatlaf.FlatDarculaLaf;

import java.awt.*;

public class MainGUI extends JFrame {

    private CardLayout cLayout;
    private JPanel screens;

    private GamePanel gamePanel;
    private EndPanel endPanel;
    private ArcadePanel arcadePanel;
    private MainMenuPanel mainPanel;
    private CustomPanel customPanel;
    private HowToPanel howToPanel;

    public Font tarotFont;
    
    private GameplayLogicInterface gameplayLogic;

    public MainGUI() {
        setTitle("The Hanged Man: A Hangman Experience");
        setPreferredSize(new Dimension(1500, 1000)); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        UIManagerUtil.setUIFont("res/Alice_in_Wonderland_3.ttf", 40f);

        createCardLayout();
        
        changeTheme("SunriseTheme");
        updateScreens(MainMenuPanel.NAME);

        pack();
        setVisible(true);
    }

    /**
     * Should be called in relation to theme changes.
     * Used to remove all panels from the CardLayout
     * and reads them. This reading allows for 
     * theme changes to apply to all screens.
     */
    private void updateScreens(String currentPanel) {
        // Clear out the old one panels from the card
        screens.removeAll();

        // Creating new versions of the panels
        mainPanel = new MainMenuPanel(this);
        gamePanel = new GamePanel(this);
        endPanel = new EndPanel(this);
        howToPanel = new HowToPanel(this);
        arcadePanel = new ArcadePanel(this);
        customPanel = new CustomPanel(this);

        // Adding them to the screens JPanel
        screens.add(mainPanel, MainMenuPanel.NAME);
        screens.add(gamePanel, GamePanel.NAME);
        screens.add(endPanel, EndPanel.NAME);
        screens.add(howToPanel, HowToPanel.NAME);
        screens.add(arcadePanel, ArcadePanel.NAME);
        screens.add(customPanel, CustomPanel.NAME);

        showCard(currentPanel);
    }

    /**
     * Creates the JPanel that
     * uses CardLayout, allowing for
     * multiple JPanels to be switched
     * between without having to 
     * start a new JFrame each time.
     */
    private void createCardLayout() {
        screens = new JPanel();
        cLayout = new CardLayout();
        screens.setLayout(cLayout);
        add(screens);
    }

    public void changeTheme(String themeName) {
        if (themeName.compareTo("SunriseTheme") == 0) {
            try {
                UIManager.setLookAndFeel(new SunriseTheme());
            } catch (Exception ex) {
                System.err.println("Failed to initialize SunriseTheme");
            }
        } else if (themeName.compareTo("SunsetTheme") == 0) {
            try {
                UIManager.setLookAndFeel(new SunsetTheme());
            } catch (Exception ex) {
                System.err.println("Failed to initialize SunsetTheme");
            }
        } else if (themeName.compareTo("MoonriseTheme") == 0) {
            try {
                UIManager.setLookAndFeel(new MoonriseTheme());
            } catch (Exception ex) {
                System.err.println("Failed to initialize MoonriseTheme");
            }
        } else {
            System.out.println("Failed to find theme, default to darcula");
            try {
                UIManager.setLookAndFeel(new FlatDarculaLaf());
            } catch (Exception ex) {
                System.err.println("Failed to initialize LaF");
            }
        }

        updateScreens(CustomPanel.NAME);
    }

    /**
     * Method used to switch between all of the cards/screens
     * Also has a tester for if it is the end screen and
     * the game is over in order to log and send over the 
     * game statistics.
     */
    public void showCard(String key) {
        //Changes the current screen depending on card
        cLayout.show(screens, key);

        //If back to the main screen, it should show the true front menu
        if (key.equals(MainMenuPanel.NAME)) {
            mainPanel.correctScreenDisplay();
            gameplayLogic = null;
        }
        
        //If the game is over and we are on the end panel
        //Save the game stats, update all screens, and send game 
        //stats to end screen
        if (key.equals(EndPanel.NAME) && gamePanel.isGameOver()) {
            String[] gameInformationArray = getGameStats();            
            endPanel.parseGameStats(gameInformationArray);
            
            gameplayLogic = null;
        }
        
        //If the game is over and we are on the arcade panel
        //Save the game stats, update all screens, and send game 
        //stats to arcade screen
        if (key.equals(ArcadePanel.NAME) && gamePanel.isGameOver()) {
            String[] gameInformationArray = getGameStats();
            arcadePanel.parseGameStats(gameInformationArray);
        }
    }

    /**
     * Method used to switch between all of the cards/screens
     * Function overload as it passes in the game difficulty
     */
    public void showCard(String key, GameDifficulty difficulty) {
        
        cLayout.show(screens, key);
        
        if(gameplayLogic == null) {
        	if(difficulty == GameDifficulty.ARCADE) {
        		gameplayLogic = new ArcadeGameplayLogic();
        	}
        	else {
        		gameplayLogic = new RegularGameplayLogic();
        	}
        }
        
        gamePanel.runGameRound(difficulty, gameplayLogic);
    }

    /**
     * Creates and returns an array using the game
     * stats of isGameWon and the target word for
     * the round of the game.
     */
    private String[] getGameStats() {
        String[] gameStats = {gamePanel.isGameWon() ? "true" : "false", gamePanel.getTargetWord(), gamePanel.getNumPoints(), gamePanel.getDifficulty()};
        return gameStats;
    }
}