import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

class TestMain extends JPanel {
    private static final int PREF_W = 600;
    private static final int PREF_H = 450;
    private CardLayout cardLayout = new CardLayout();
    private MenuView menuView = new MenuView(this);
    private ActionView actionView = new ActionView(this);

    public TestMain() {
        setLayout(cardLayout);
        add(menuView, MenuView.NAME);
        add(actionView, ActionView.NAME);
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        } else {
            return new Dimension(PREF_W, PREF_H);
        }
    }

    public void showCard(String key) {
        cardLayout.show(this, key);
        // or swap by hand if you don't want to use CardLayout
        // but remember to revalidate and repaint whenever doing it by hand
    }
}