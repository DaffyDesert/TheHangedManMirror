import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

class MenuView extends JPanel {
    public static final String NAME = "Menu View";

    public MenuView(TestMain myMain) {
        setName(NAME);
        setBorder(BorderFactory.createTitledBorder("Menu"));
        add(new JButton(new GoToAction("Action 1", ActionView.NAME, myMain)));
    }

}