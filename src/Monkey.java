import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Monkey extends JLabel{
    int xPos;
    int yPos;
    int height = 100;
    int width = 100;

    int reachRadius = 70;

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

    public void CheckForBalloon(ArrayList<Balloon> balloonList) {

        if (balloonList.isEmpty()) return;

    //    System.out.println(balloonList.get(0).xPos);

        for (var balloon : balloonList) {

            if (CheckCollision(balloon)) {
                System.out.println("Collisision");
            }
        }

    }

    public void ShowRange() {
        JPanel rangeX = new JPanel();
        rangeX.setBounds(this.xPos - reachRadius, this.yPos - reachRadius, reachRadius * 2, reachRadius * 2);
        rangeX.setBackground(Color.red);



        this.game.getFrame().add(rangeX);

    }



    public boolean CheckCollision(Balloon balloon) {
        int xPos = this.xPos - reachRadius;
        int yPos = this.yPos - reachRadius;
        int width = reachRadius * 2;
        int height = reachRadius * 2;

        if (xPos < balloon.xPos + balloon.width && xPos + width > balloon.xPos && yPos < balloon.yPos + balloon.height && yPos + height > balloon.yPos) return true;
        else return false;
    }

    public void Shoot(Balloon targetBallon) {

    }
}
