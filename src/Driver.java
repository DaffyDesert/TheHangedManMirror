import javax.swing.*;

public class Driver {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainGUI temp = new MainGUI();
        });
        
    }
}