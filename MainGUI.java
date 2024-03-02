import javax.swing.*;

import com.formdev.flatlaf.FlatDarculaLaf;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainGUI extends JFrame {

    private CardLayout cLayout;
    private JPanel screens;

    private GamePanel gamePanel;
    private EndPanel endPanel;

    // FIXME: Used for screen switching, could be more optimal?
    private enum PanelName {
        GAME_SCREEN, END_SCREEN
    }

    private PanelName switchPanel = PanelName.GAME_SCREEN;

    public final String GAME_PANEL = "Game Panel";
    public final String END_PANEL = "End Panel";

    // FIXME: Temp, for later sprint with font
    public Font tarotFont;

    /**
     * Runs the game
     */
    public static void main(String[] args) {
        MainGUI temp = new MainGUI();

        temp.getRootPane().putClientProperty("JRootPane.titleBarBackground", Color.black);
        temp.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.white);

    }

    public MainGUI() {
        setTitle("The Hanged Man: A Hangman Experience");
        setPreferredSize(new Dimension(1000, 1000)); // FIXME: Will be rewritten when window changing is accounted for
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createFont();   // FIXME: temporary, will be used/fixed later

        createCardLayout();
        pack();
        setVisible(true);

        changeTheme("SunriseTheme");
        updateScreens();
    }

    /**
     * Should be called in relation to theme changes.
     * Used to remove all panels from the CardLayout
     * and readds them. This readding allows for 
     * theme changes to apply to all screens.
     */
    private void updateScreens() {
        // Clear out the old one and make new panels?
        screens.removeAll();

        // Creating new versions of the screen
        gamePanel = new GamePanel();
        endPanel = new EndPanel();

        // Adding them to the screens JPanel
        screens.add(gamePanel, GAME_PANEL);
        screens.add(endPanel, END_PANEL);

        changePanel(switchPanel);
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

    /*
     * Used to change between panels,
     * calls the corresponding show
     * function that sets the JPanel
     * as visible with CardLayout.
     */
    private void changePanel(PanelName currentPanel) {
        switch (currentPanel) {
            case GAME_SCREEN:
                showGamePanel();
                break;
            case END_SCREEN:
                showEndPanel();
                break;
        }
    }

    /*
     * Called when the GamePanel needs to be shown.
     *      (called from within changePanel();)
     * Displays the game panel.
     * Starts a game round.
     * 
     * Also handles sending to the next screen,
     * awaits for player to win or lose
     * before sending back to changePanel();
     */
    private void showGamePanel() {
        cLayout.show(screens, GAME_PANEL);
        gamePanel.runGameRound();
        while (!gamePanel.isGameOver()) {
            // FIXME: Isn't ideal at all
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        // FIXME: Should it sit on the screen for a moment so that they can see their
        switchPanel = PanelName.END_SCREEN;
        changePanel(switchPanel);

    }

    /*
     * Called when the EndPanel needs to be shown.
     *      (called from within changePanel();)
     * Displays the end panel.
     * Sends over the stats based on the most recent
     * version of gamePannel. 
     * 
     * Also handles sending to the next screen,
     * awaits button within endPanel to be clicked
     * before sending back to changePanel();
     */
    private void showEndPanel() {
        cLayout.show(screens, END_PANEL);

        endPanel.receiveGameStats(gamePanel.isGameWon(), gamePanel.getTargetWord());

        while (!endPanel.isAgainButtonClicked()) {
            // FIXME: Isn't ideal at all
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        switchPanel = PanelName.GAME_SCREEN;
        changePanel(switchPanel);
    }

    // FIXME: Ignore, for later sprint, was used in testing but unusable at the moment
    private void changeTheme(String themeName) {
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

        updateScreens();
    }

    // FIXME: Ignore, for later sprint, fonts will not be used in sprint 1
    private void createFont() {
        try {
            // create the font to use. Specify the size!
            tarotFont = Font.createFont(Font.TRUETYPE_FONT, new File("Tarot-Font.ttf")).deriveFont(13);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            // register the font
            ge.registerFont(tarotFont);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
    }
}