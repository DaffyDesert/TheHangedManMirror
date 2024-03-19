import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

class ChangeToAction extends AbstractAction {
    private String key;
    private MainGUI myMain;

    public ChangeToAction(String name, String key, MainGUI myMain) {
        super(name);
        this.key = key;
        this.myMain = myMain;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        myMain.showCard(key);
    }
}