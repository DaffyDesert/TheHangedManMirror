import javax.swing.*;

import com.formdev.flatlaf.FlatDarculaLaf;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainGUI extends JFrame {
    /*
     * Names of the panels/screens the game will have
     */
    public final String GAME_PANEL = "Game Panel";
    public final String END_PANEL = "End Panel";

    // Used for switching between screens
    private CardLayout cLayout;
    private JPanel screens;

    // The panels representing each screen
    private GamePanel gamePanel;
    private EndPanel endPanel;

    // FIXME: Temporary variable used for showing the switching between screens
    private enum PanelName {
        GAME_SCREEN, END_SCREEN
    }

    private PanelName switchPanel = PanelName.GAME_SCREEN;

    // FIXME: Temp variable with string name of theme
    private static String nextTheme = "SunsetTheme";

    // FIXME: Temp, creating a font object to test
    public Font tarotFont;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new SunriseTheme());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        MainGUI temp = new MainGUI();

        temp.getRootPane().putClientProperty("JRootPane.titleBarBackground", Color.black);
        temp.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.white);

    }

    public MainGUI() {

        setTitle("The Hanged Man: A Hangman Experience");
        setPreferredSize(new Dimension(1000, 1000)); // FIXME: Will be rewritten when window changing is accounted for
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createFont();

        createCardLayout();

        combinePanels();

        pack();
        setVisible(true);

        updateScreens();
    }

    private void changeTheme(String themeName) {
        if (themeName.compareTo("SunriseTheme") == 0) {
            nextTheme = "SunsetTheme";
            try {
                UIManager.setLookAndFeel(new SunriseTheme());
            } catch (Exception ex) {
                System.err.println("Failed to initialize SunriseTheme");
            }
        } else if (themeName.compareTo("SunsetTheme") == 0) {
            nextTheme = "MoonriseTheme";
            try {
                UIManager.setLookAndFeel(new SunsetTheme());
            } catch (Exception ex) {
                System.err.println("Failed to initialize SunsetTheme");
            }
        } else if (themeName.compareTo("MoonriseTheme") == 0) {
            nextTheme = "SunriseTheme";
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

    private void updateScreens() {
        // Clear out the old one and make new panels?
        screens.removeAll();

        // Creating new versions of the screen
        gamePanel = new GamePanel();
        endPanel = new EndPanel();

        // Adding them to the screens JPanel
        screens.add(gamePanel, GAME_PANEL);
        screens.add(endPanel, END_PANEL);

        // Ensure we are on the right screen
        // FIXME: Have it cycle
        // call the changePanel();
        changePanel(switchPanel);
    }

    private void createCardLayout() {
        screens = new JPanel();
        cLayout = new CardLayout();
        screens.setLayout(cLayout);
    }

    private JPanel createTempButtonsPanel() {
        // FIXME: for the switch button at bottom, will be removed
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
        JButton button = new JButton("Switch Screens (TEMPORARY)");
        // button.addActionListener(e -> switchPanes());
        JButton button2 = new JButton("Switch Themes");
        button2.addActionListener(e -> changeTheme(nextTheme));

        buttonPanel.add(button);
        buttonPanel.add(button2);

        return buttonPanel;
    }

    public void combinePanels() {
        setLayout(new BorderLayout());
        add(screens, BorderLayout.CENTER);
        add(createTempButtonsPanel(), BorderLayout.SOUTH);
    }

    private void changePanel(PanelName currentPanel) {
        switch (currentPanel) {
            case GAME_SCREEN:
                System.out.println("Game Panel");
                showGamePanel();
                break;
            case END_SCREEN:
                System.out.println("End Panel");
                showEndPanel();
                // send over the information about the game here?
                break;
        }
    }

    private void showGamePanel() {
        cLayout.show(screens, GAME_PANEL);
        gamePanel.runGameRound();
        while (!gamePanel.checkGameOver()) {
            // FIXME: Isn't ideal at all
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        // FIXME: Should it sit on the screen for a moment so that they can see their
        // fail or success?
        switchPanel = PanelName.END_SCREEN;
        changePanel(switchPanel);

    }

    private void showEndPanel() {
        cLayout.show(screens, END_PANEL);
        while (!endPanel.wasAgainButtonClicked()) {
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