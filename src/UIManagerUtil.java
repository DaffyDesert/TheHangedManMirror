import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class UIManagerUtil {
    public static void setUIFont(String fontPath, float fontSize) {
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(fontSize);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

            // Set the font for all Swing components
            UIDefaults defaults = UIManager.getDefaults();
            for (Object key : defaults.keySet()) {
                Object value = defaults.get(key);
                if (value instanceof Font) {
                    defaults.put(key, customFont);
                }
            }
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            // Handle font loading errors here
        }
    }
}
