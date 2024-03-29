import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

class ChangeToAction extends AbstractAction {
    private String key;
    private MainGUI myMain;
    private GameDifficulty difficulty;

    public ChangeToAction(String name, String key, MainGUI myMain, GameDifficulty difficulty) {
        super(name);
        this.key = key;
        this.myMain = myMain;
        this.difficulty = difficulty;
    }

    public ChangeToAction(String name, String key, MainGUI myMain) {
        super(name);
        this.key = key;
        this.myMain = myMain;
        this.difficulty = GameDifficulty.NONE;
    }

    public void setDifficulty(GameDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (GameDifficulty.NONE == difficulty) {
            myMain.showCard(key);
        } else {
            myMain.showCard(key, difficulty);
        }
    }
}