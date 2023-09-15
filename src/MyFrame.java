import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    MyFrame(){
        this.setTitle("Virus");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.setSize(420,420);
        this.setVisible(true);

        ImageIcon image = new ImageIcon("milton_real.jpg");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(9, 130, 0));
    }
}
