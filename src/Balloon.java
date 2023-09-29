import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Balloon extends JLabel {
    public int xPos;

    Color usedColor = Color.red;
    int speed = 4;
    int yPos;
    int height = 40;
    int width = 30;
    int madeTurns = 0;
    Game game;

    String tag = "balloon";
    String[] turnPos = {"x_+_225", "y_-_100", "x_+_100", "y_-_10", "x_+_300", "y_+_400", "x_+_700"};

    Balloon(int _xPos, int _yPos, Game game) {
        this.xPos = _xPos;
        this.yPos = _yPos;
        this.game= game;

        this.setSize(width, height);
        this.setLocation(xPos, yPos);
        this.setBackground(Color.red);

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("balloon1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image dimg = img.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        this.setIcon(imageIcon);
        game.getFrame().add(this);
    }

    public void Spawn(){

    }

    public void Move(Track track) {
        xPos += track.TurnCheck(this)[0];
        yPos += track.TurnCheck(this)[1];
        this.setLocation(xPos, yPos);


    }


}
