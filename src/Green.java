/**
 * Title      : Green.java
 * Description: This class contains the method to paint green light.
 * @author      Yueting Du
 * @version     1.0
 */
import java.awt.*;
import javax.swing.*;
public class Green extends JPanel {
    /**
* This method is to paint green light
* @param g
*/
public void paintComponent(Graphics g) {
g.setColor(Color.green);
g.fillOval(50,0,30,30);
}
}