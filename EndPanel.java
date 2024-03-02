import java.awt.*;
import javax.swing.*;
import javax.swing.Box.Filler;

public class EndPanel extends JPanel {

    private boolean wasAgainButtonClicked = false;

    public EndPanel() {
        setLayout(new BorderLayout());

        Box.Filler glue = (Filler) Box.createVerticalGlue();
        glue.changeShape(glue.getMinimumSize(),
                new Dimension(0, Short.MAX_VALUE), // make glue greedy
                glue.getMaximumSize());

        Box box = Box.createVerticalBox();
        box.add(createStatusPanel());
        box.add(createButtonPanel());
        box.add(glue);

        add(box, BorderLayout.CENTER);
    }

    private JPanel createStatusPanel() {
        JPanel statusPanel = new JPanel();

        JLabel statusLabel = new JLabel("You Win");

        statusPanel.add(statusLabel);

        return statusPanel;
    }

    private JPanel createButtonPanel() {
        JPanel statusPanel = new JPanel();

        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(e -> quitButtonClicked());
        JButton againButton = new JButton("Play Again?");
        againButton.addActionListener(e -> againButtonClicked());

        statusPanel.add(quitButton);
        statusPanel.add(againButton);

        return statusPanel;
    }

    private void quitButtonClicked() {
        System.exit(0);
    }

    private void againButtonClicked() {
        wasAgainButtonClicked = true;
        System.out.println("clicked play again button");
    }

    public boolean wasAgainButtonClicked() {
        return wasAgainButtonClicked;
    }

}