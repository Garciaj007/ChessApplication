package chessapplication.util;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.Icon;
/**
 *
 * @author jurie
 */
public class Utils {
    public static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
    Image img = icon.getImage();  
    Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
    return new ImageIcon(resizedImage);
}
}
