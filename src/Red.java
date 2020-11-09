/**
 * Title      : Red.java
 * Description: This class contains the method to paint red light.
 * @author      Yueting Du
 * @version     1.0
 */
import java.awt.*;
import javax.swing.*;
public class Red extends JPanel {
    /**
* This method is to paint red light
* @param g
*/

public void paintComponent(Graphics g) {
g.setColor(Color.red);
g.fillOval(50,0,30,30);
}
}