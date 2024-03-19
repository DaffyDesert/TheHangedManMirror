import javax.swing.JButton;

import javax.swing.BorderFactory;

import javax.swing.JPanel;

class ActionView extends JPanel {
    public static final String NAME = "Action View 1";

    public ActionView(TestMain myMain) {
        setName(NAME);
        setBorder(BorderFactory.createTitledBorder(NAME));
        add(new JButton(new GoToAction("Main Menu", MenuView.NAME, myMain)));
    }

}