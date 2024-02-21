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

    private boolean playerWon;

    private Font tarotFont;
    
    private JPanel statusPanel;
    private JLabel statusLabel;
    
    public GameOverScreen(boolean playerWon, int score, int level, String word) {

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(BACKGROUND_COLOR);

        createCustomFont(); //this initializes the custom font
        
        makeStatusPanel();
        
        add(statusPanel, BorderLayout.CENTER);
        
        
        setStatusLabelText();
        
        setVisible(true);   
    }

    private JPanel makeStatusPanel() {
        statusPanel = new JPanel();
        statusPanel.setBackground(BACKGROUND_COLOR);
        statusPanel.setPreferredSize(new Dimension(1200, 200));
        GridLayout layout = new GridLayout(4,1);
        layout.setHgap(5);
        statusPanel.setLayout(layout);

        statusLabel = new JLabel();
        
        statusLabel.setHorizontalAlignment(JLabel.CENTER);
        statusLabel.setFont(tarotFont);
        statusLabel.setForeground(FOREGROUND_COLOR);
        statusPanel.add(statusLabel);

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

    private void createCustomFont() {
        try {
            //create the font to use. Specify the size!
            tarotFont = Font.createFont(Font.TRUETYPE_FONT, new File("TarotPamelaColmanSmith-Regular.ttf")).deriveFont(30f);
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