import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Monkey extends JLabel{
    int xPos;
    int yPos;
    int height = 100;
    int width = 100;

    Game game;

    String tag = "monkey";

    Monkey(int _xPos, int _yPos, Game game) {
        this.xPos = _xPos;
        this.yPos = _yPos;
        this.game = game;

        this.setSize(width, height);
        this.setLocation(xPos, yPos);
        this.setBackground(Color.red);


        this.setIcon(returnImageIcon(this, "classic-monkey.png"));
        game.getFrame().add(this);
    }


    public ImageIcon returnImageIcon(JLabel monkey, String imgPath) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(imgPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image dimg = img.getScaledInstance(monkey.getWidth(), monkey.getHeight(), Image.SCALE_SMOOTH);

        return new ImageIcon(dimg);
    }

    public void Shoot(int[] pos) {

    }
}
