import javax.swing.*;
import java.awt.*;

public class MyPanel extends JFrame {

    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;
    Image enemy;
    Image background;
    Timer timer;
    int xVelocity = 1;
    int yVelocity = 1;
    int x = 0;
    int y = 0;

    MyPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

    }

}
