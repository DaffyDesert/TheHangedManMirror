import javax.swing.*;

public class Driver {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainGUI temp = new MainGUI();
        });
        
    }

    private static void createAndShowGui() {
        MainGUI mainPanel = new MainGUI();
        JFrame frame = new JFrame("Pass Reference");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}