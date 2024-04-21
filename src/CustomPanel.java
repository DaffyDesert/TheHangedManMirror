import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CustomPanel extends JPanel {

    public static final String NAME = "CUSTOM";

    private MainGUI myMain;

    private AudioPlayerInterface AudioPlayer;

    private enum ButtonValues {
        SUNRISE, SUNSET, MOONRISE
    }

    public CustomPanel(MainGUI mainPass) {
        myMain = mainPass;

        AudioPlayer = new AudioPlayer();

        setBorder(new EmptyBorder(10, 10, 10, 10));

        add(createCustomButtons());
    }

    /*
     * Creates the JPanel containing the user buttons.
     */
    private JPanel createCustomButtons() {
        JPanel buttonPanel = new JPanel();
        GridLayout tempLayout = new GridLayout(7, 1);
        tempLayout.setVgap(80);
        buttonPanel.setLayout(tempLayout);
        
        JLabel titleLabel = new JLabel("Customize your game expereince here:", SwingConstants.CENTER);

        JButton sunriseButton = new JButton("Sunrise Theme");
        JButton sunsetButton = new JButton("Sunset Theme");
        JButton moonriseButton = new JButton("Moonrise Theme");

        sunriseButton.addActionListener(e -> buttonClicked(ButtonValues.SUNRISE));
        sunsetButton.addActionListener(e -> buttonClicked(ButtonValues.SUNSET));
        moonriseButton.addActionListener(e -> buttonClicked(ButtonValues.MOONRISE));

        sunriseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AudioPlayer.buttonHover();
            }
        });

        sunsetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AudioPlayer.buttonHover();
            }
        });

        moonriseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AudioPlayer.buttonHover();
            }
        });

        JButton menuButton =  new JButton(new ChangeToAction("Return to Menu", MainMenuPanel.NAME, myMain));

        buttonPanel.add(new JLabel(""));
        buttonPanel.add(titleLabel);
        buttonPanel.add(sunriseButton);
        buttonPanel.add(sunsetButton);
        buttonPanel.add(moonriseButton);
        buttonPanel.add(menuButton);
        buttonPanel.add(new JLabel(""));

        return buttonPanel;
    }

    private void buttonClicked(ButtonValues buttonValue) {
        switch (buttonValue) {
            case SUNRISE:
                myMain.changeTheme("SunriseTheme");
                AudioPlayer.buttonClick();
                break;
            case SUNSET:
                myMain.changeTheme("SunsetTheme");
                AudioPlayer.buttonClick();
                break;
            case MOONRISE:
                myMain.changeTheme("MoonriseTheme");
                AudioPlayer.buttonClick();
                break;
        }
    }
}