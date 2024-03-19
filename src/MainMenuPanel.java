import javax.swing.*;

import javafx.event.ActionEvent;

import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenuPanel extends JPanel {

    private JButton easyButton, mediumButton, hardButton, extremeButton, arcadeButton, backButton, playButton, howToButton, customButton, quitButton;

    private enum ButtonValues {
        PLAY, HOWTO, CUSTOM, QUIT, EASY, MEDIUM, HARD, EXTREME, ARCADE, BACK
    }

    public MainMenuPanel() {
        JPanel tempPanel = new JPanel();
        tempPanel.setLayout(new GridLayout(1, 2));
        

        tempPanel.add(createDrawingPanel());
        tempPanel.add(createButtonPanel());

        add(tempPanel);
    }

    /*
     * XXXXXXXXXXXXXXXXXX
     */
    private JPanel createDrawingPanel() {
        JPanel tempPanel = new JPanel();

        Box box = Box.createVerticalBox();

        JLabel titleLabel = new JLabel("The Hanged Man:");
        JLabel subTitleLabel = new JLabel("A Hangman Expreience");
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
     * XXXXXXXXXXXXXXXXXX
     */
    private JPanel createButtonPanel() {
        JPanel tempPanel = new JPanel();
        GridLayout tempLayout = new GridLayout(6, 1);
        tempLayout.setVgap(80);
        tempPanel.setLayout(tempLayout);

        playButton = new JButton("Play Hanged Man");
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
     * 
     */
    private JPanel createGameDifficultyButtons() {
        JPanel tempPanel = new JPanel();
        GridLayout tempLayout = new GridLayout(8, 1);
        tempLayout.setVgap(60);
        tempPanel.setLayout(tempLayout);

        easyButton = new JButton("Easy");
        mediumButton = new JButton("Medium");
        hardButton = new JButton("Hard");
        extremeButton = new JButton("Extreme");
        arcadeButton = new JButton("Arcade Mode");
        backButton = new JButton("Back to Main Menu");

        easyButton.addActionListener(e -> buttonClicked(ButtonValues.EASY));
        mediumButton.addActionListener(e -> buttonClicked(ButtonValues.MEDIUM));
        hardButton.addActionListener(e -> buttonClicked(ButtonValues.HARD));
        extremeButton.addActionListener(e -> buttonClicked(ButtonValues.EXTREME));
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

    private void buttonClicked(ButtonValues buttonValue) {
        switch (buttonValue) {
            case PLAY:
                System.out.println("Pressed play");
                break;
            case HOWTO:
            System.out.println("Pressed how to");
                break;
            case CUSTOM:
                System.out.println("Pressed custom");
                break;
            case QUIT:
                System.out.println("Pressed quit");
                break;
        }
    }
}