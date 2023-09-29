import static java.lang.Integer.parseInt;

public class Track {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    String[] turnPositions;

    Track(String[] _turnPositions) {
        this.turnPositions = _turnPositions;

    }


    public int[] TurnCheck(Balloon balloon) {
        // ["x_-_200", "y_+_300", "x_-_300"]
        int[] turnSpeed = new int[2];
        int xTurn = 0;
        int yTurn = 0;

        if (balloon.madeTurns >= turnPositions.length)
        {
            System.out.println(ANSI_RED + "The made turns is larger than the amount of turns in the track" + ANSI_RESET);
        }
        // Destruct the turnPositions
        String[] turnInfo = turnPositions[balloon.madeTurns].split("_");
        String limitAxis = turnInfo[0];
        String direction = turnInfo[1];
        int limitCoordinate = parseInt(turnInfo[2]);

    //    System.out.println(limitAxis + " " + direction + " " + limitCoordinate);


        switch (limitAxis) {
            case "x":
                if (direction.equals("+")) {
                    if (balloon.xPos < limitCoordinate) {
                        xTurn = balloon.speed;
                    } else balloon.madeTurns++;
                } else {
                    if (balloon.xPos > limitCoordinate) {
                        xTurn = -balloon.speed;
                    } else balloon.madeTurns++;
                }
                break;
            case "y":
                if (direction.equals("+")) {
                    if (balloon.yPos < limitCoordinate) {
                        yTurn = balloon.speed;
                    } else balloon.madeTurns++;
                } else {
                    if (balloon.yPos > limitCoordinate) {
                        yTurn = -balloon.speed;
                    } else balloon.madeTurns++;
                }
                break;
        }


        turnSpeed[0] = xTurn;
        turnSpeed[1] = yTurn;
      // DEBUG System.out.println("X " + xTurn + " : Y " + yTurn);
        return turnSpeed;
    }

}

