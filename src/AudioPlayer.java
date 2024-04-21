import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioPlayer implements AudioPlayerInterface {

    private File buttonClick;
    private File buttonHover;
    private File correctGuess;
    private File incorrectGuess;
    private File gameWon;
    private File gameLost;


    AudioPlayer() {
        this.buttonClick = new File("res/SFX/buttonClick.wav");
        this.buttonHover = new File("res/SFX/buttonHover.wav");
        this.correctGuess = new File("res/SFX/CorrectGuess.wav");
        this.incorrectGuess = new File("res/SFX/IncorrectGuess.wav");
        this.gameWon = new File("res/SFX/gameWon.wav");
        this.gameLost = new File("res/SFX/gameLost.wav");
    }

    @Override
    public void buttonHover() {
        try {  
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(buttonHover));
            clip.start();
        } catch (Exception e) {
            System.out.println(e);
        }    
    }

    @Override
    public void buttonClick() {
        try {  
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(buttonClick));
            clip.start();
        } catch (Exception e) {
            System.out.println(e);
        }   
        
    }

    @Override
    public void correctGuess() {
        try {  
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(correctGuess));
            clip.start();
        } catch (Exception e) {
            System.out.println(e);
        }   
        
    }

    @Override
    public void incorrectGuess() {
        try {  
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(incorrectGuess));
            clip.start();
        } catch (Exception e) {
            System.out.println(e);
        }   
        
    }

    @Override
    public void gameWon() {
        try {  
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(gameWon));
            clip.start();
        } catch (Exception e) {
            System.out.println(e);
        }   
       
    }

    @Override
    public void gameLost() {
        try {  
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(gameLost));
            clip.start();
        } catch (Exception e) {
            System.out.println(e);
        }   
       
    }
    
}
