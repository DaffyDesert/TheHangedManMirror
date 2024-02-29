import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.Dimension;

import java.io.File;
import java.io.IOException;

import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * File Name: GameOverScreen.java
 * Purpose:
 *  The purpose of the GameOver class file is to
 * handle the visual components of the game over screen
 * for the player. It handles drawing the window and all
 * of its components. Currently, the screen states whether
 * the player won or lost, what levels the completed (or
 * failed to complete). This class also allows the player
 * (whether they won or lost) to restart the game or quit.
 */

public class GameOverScreen extends JFrame {
    private static final int FRAME_WIDTH = 1200;
    private static final int FRAME_HEIGHT = 1100;
    private static final Color BACKGROUND_COLOR = Color.black;
    private static final Color FOREGROUND_COLOR = Color.white;

    private Font tarotFont;
    
    private JPanel buttonPanel, statusPanel;
    private JButton quitButton, restartButton;
    private JLabel statusLabel, replayLabel, scoreLabel, levelCompleted, wordLabel;

    private boolean isRestarting = false;
    private boolean isPlayerTurn, playerWon;
    private int playerInput = -1;
    
    public GameOverScreen(boolean playerWon, int score, int level, String word) {
        this.playerWon = playerWon;

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(BACKGROUND_COLOR);

        createCustomFont(); //this initializes the custom font
        
        makeStatusPanel();
        makeButtonPanel();
        
        add(buttonPanel, BorderLayout.SOUTH);
        add(statusPanel, BorderLayout.CENTER);
        
        addQuitButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        addRestartButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerInput = 0;
                isPlayerTurn = false;
                isRestarting = true;
            }
        });

        setStatusLabelText();
        setReplayLabel();
        setScoreText(score);
        setLevelCompletedText(level);
        //setCorrectWordText(word);
        
        setVisible(true);      
    }

    private void makeButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setBackground(BACKGROUND_COLOR);
        
        quitButton = makePrettyButton("Quit");
        restartButton = makePrettyButton("Restart");
        
        buttonPanel.add(quitButton);
        buttonPanel.add(restartButton);
    }

    private JPanel makeStatusPanel() {
        statusPanel = new JPanel();
        statusPanel.setBackground(BACKGROUND_COLOR);
        statusPanel.setPreferredSize(new Dimension(1200, 200));
        GridLayout layout = new GridLayout(4,1);
        layout.setHgap(5);
        statusPanel.setLayout(layout);

        statusLabel = new JLabel();
        replayLabel = new JLabel();
        scoreLabel = new JLabel();
        levelCompleted = new JLabel();
        
        statusLabel.setHorizontalAlignment(JLabel.CENTER);
        statusLabel.setFont(tarotFont);
        statusLabel.setForeground(FOREGROUND_COLOR);

        replayLabel.setHorizontalAlignment(JLabel.CENTER);
        replayLabel.setFont(tarotFont);
        replayLabel.setForeground(FOREGROUND_COLOR);

        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setFont(tarotFont);
        scoreLabel.setForeground(FOREGROUND_COLOR);

        levelCompleted.setHorizontalAlignment(JLabel.CENTER);
        levelCompleted.setFont(tarotFont);
        levelCompleted.setForeground(FOREGROUND_COLOR);

        /*wordLabel.setHorizontalAlignment(JLabel.CENTER);
        wordLabel.setFont(tarotFont);
        wordLabel.setForeground(FOREGROUND_COLOR);*/

        statusPanel.add(statusLabel);
        //statusPanel.add(wordLabel);
        statusPanel.add(levelCompleted);
        statusPanel.add(scoreLabel);
        statusPanel.add(replayLabel);

        return statusPanel;
    }
    
    private void setStatusLabelText() {
        if(playerWon) {
            statusLabel.setText("You Win");
        }
        else {
            statusLabel.setText("You Lose");
        }
    };

    private void setScoreText(int score) {
        if(playerWon) {
            String output = String.format("You earned a total of %d points", score);
            scoreLabel.setText(output);
        }else{
            String output = "You did not earn any points";
            scoreLabel.setText(output);
        }
    };

    private void setLevelCompletedText(int level) {
        String output;
        if(playerWon) {
            output = "You beat all " + level + " levels!";
        }
        else {
            output = "You failed to beat level " + level;
        }
        levelCompleted.setText(output);
    };

    /*private void setCorrectWordText(String word) {
        String output = "The correct word was " + word;
        wordLabel.setText(output);
    };*/

    private void setReplayLabel() {
        String output = "Would you like to play again? Press Restart.";
        replayLabel.setText(output);
    }

    private JButton makePrettyButton(String buttonText) {
        JButton button = new JButton(buttonText);
        button.setFont(tarotFont);
        button.setUI(new BasicButtonUI()); // Set BasicButtonUI to override look and feel
        button.setBorder(BorderFactory.createLineBorder(FOREGROUND_COLOR));
        
        return button;
    }
    
    private void addQuitButtonListener(ActionListener listener) {
        quitButton.addActionListener(listener);
    }

    private void addRestartButtonListener(ActionListener listener) {
        restartButton.addActionListener(listener);
    }

    private void createCustomFont() {
        try {
            //create the font to use. Specify the size!
            tarotFont = Font.createFont(Font.TRUETYPE_FONT, new File("1470Jenson.ttf")).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(tarotFont);
        } catch (IOException e) {
            e.printStackTrace();
        } catch(FontFormatException e) {
            e.printStackTrace();
        }
    }
    

}