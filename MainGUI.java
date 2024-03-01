import javax.swing.*;

import com.formdev.flatlaf.FlatDarculaLaf;

import java.awt.*;

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
    private JPanel gamePanel;
    private JPanel endPanel;

    // FIXME: Temporary variable used for showing the switching between screens
    private boolean isGamePanelShown;

    // FIXME: Temp variable with string name of theme
    private static String nextTheme = "SunsetTheme";

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

        createMainPanels();
        combinePanels();

        pack();
        setVisible(true);
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
        if (isGamePanelShown) {
            showGamePanel();
        } else {
            showEndPanel();
        }
    }

    private void createMainPanels() {
        gamePanel = new GamePanel();
        endPanel = new EndPanel();

        screens = new JPanel();
        cLayout = new CardLayout();
        screens.setLayout(cLayout);

        screens.add(gamePanel, GAME_PANEL);
        screens.add(endPanel, END_PANEL);
    }

    private JPanel createTempButtonsPanel() {
        isGamePanelShown = true;

        // FIXME: for the switch button at bottom, will be removed
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
        JButton button = new JButton("Switch Screens (TEMPORARY)");
        button.addActionListener(e -> switchPanes());
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

    // FIXME: for switching screens button only
    private void switchPanes() {
        if (isGamePanelShown) {
            showEndPanel();
            isGamePanelShown = false;
        } else {
            showGamePanel();
            isGamePanelShown = true;
        }
    }

    private void showGamePanel() {
        cLayout.show(screens, GAME_PANEL);
    }

    private void showEndPanel() {
        cLayout.show(screens, END_PANEL);
    }
}