import javax.swing.*;

public class PassRef {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGui();
        });
    }

    private static void createAndShowGui() {
        TestMain mainPanel = new TestMain();
        JFrame frame = new JFrame("Pass Reference");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}