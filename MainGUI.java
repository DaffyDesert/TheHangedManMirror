import javax.swing.*;
import java.awt.*;

public class MainGUI extends JFrame {
    /*
     * Names of the panels/screens the game will have
     */
    public final String GAME_PANEL = "Game Panel";
    public final String END_PANEL = "End Panel";

    // Used for switching between screens
    private final CardLayout cLayout;
    private final JPanel screens;

    // The panels representing each screen
    private JPanel gamePanel;
    private JPanel endPanel;

    // FIXME: Temporary variable used for showing the switching between screens
    private boolean isGamePanelShown;

    public MainGUI() {
        setTitle("The Hanged Man: A Hangman Experience");
        setPreferredSize(new Dimension(1000, 1000)); // FIXME: Will be rewritten when window changing is accounted for
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create all of the panels/screens
        gamePanel = new GamePanel();
        endPanel = new EndPanel();

        screens = new JPanel();
        cLayout = new CardLayout();
        screens.setLayout(cLayout);

        screens.add(gamePanel, GAME_PANEL);
        screens.add(endPanel, END_PANEL);

        // FIXME: for the switch button at bottom, will be removed
        JButton button = new JButton("Switch Screens (TEMPORARY)");
        button.addActionListener(e -> switchPanes());

        isGamePanelShown = true;

        setLayout(new BorderLayout());
        add(screens, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);

        pack();
        setVisible(true);
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