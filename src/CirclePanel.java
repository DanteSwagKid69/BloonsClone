import javax.swing.*;
import java.awt.*;

public class CirclePanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        g.drawOval(100, 100, 100, 100);
    }
}