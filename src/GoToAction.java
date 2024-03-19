import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

class GoToAction extends AbstractAction {
    private String key;
    private TestMain myMain;

    public GoToAction(String name, String key, TestMain myMain) {
        super(name);
        this.key = key;
        this.myMain = myMain;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        myMain.showCard(key);
    }
}