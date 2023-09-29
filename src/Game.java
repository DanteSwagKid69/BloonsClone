import java.util.ArrayList;
import java.util.List;

public class Game {
    private MyFrame frame = new MyFrame();

    public Game(){
        start();
    }
    public void start(){
        // FPS Variables
        int FPS = 30;
        double avarageFPS = 0;
        long startTime;
        long URDTimeMillis;
        long waitTime;
        long totalTime = 0;
        int frameCount = 0;
        int maxFrameCount = 30;
        long targetTime = 1000 / FPS;

        Monkey monkey = new Monkey(100, 100, this);


        String[] turnPos = {"x_+_225", "y_-_100", "x_+_100", "y_-_10", "x_+_300", "y_+_400", "x_+_800"};
        Track track = new Track(turnPos);
        int[] spawnPoint = {-30, 400};

        //List containing all Balloons in this wave
        List<Balloon> balloonList = new ArrayList<Balloon>();

        while (true) {
            //Starting the time system
            startTime = System.nanoTime();

            if (frameCount == 29)
            {
                balloonList.add(new Balloon(spawnPoint[0], spawnPoint[1], this));
            }

            //Move all Balloons in the balloonList
            for (Balloon ba : balloonList) {
                ba.Move(track);
            }




            GameDraw();


            //Handling capping the FPS
            URDTimeMillis = (System.nanoTime() - startTime) / 1000000;
            waitTime = targetTime - URDTimeMillis; // Extra time to wait
            try {
                Thread.sleep(waitTime);
            } catch (Exception e) {
                System.out.println(e);
            }
            totalTime += System.nanoTime() - startTime;
            frameCount++;
            if (frameCount == maxFrameCount) {

                avarageFPS = 1000.0 / ((totalTime / frameCount) / 1000000);
                frameCount = 0;
                totalTime = 0;
                System.out.println(avarageFPS);
            }
        }
    }

    public void GameDraw() {
        frame.setVisible(true);
    }

    public List<Balloon> SpawnBalloons(int amountOfBalloons, int[] spawnPoint, int frame, String balloonType) {
        List<Balloon> balloonList = new ArrayList<Balloon>();


        return balloonList;
    }

    public MyFrame getFrame() {
        return frame;
    }
}
