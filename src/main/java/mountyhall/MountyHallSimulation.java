package mountyhall;

public class MountyHallSimulation {
    public static void simulate1000Games(boolean switchDoor) {
        int gamesPlayed = 0;
        int gamesWon = 0;
        while (gamesPlayed < 1000) {
            MountyHall game = new MountyHall(DoorFactory.generateThreeDoors(), new Player());
            game.playerSelectDoor(randomSelectedDoor());
            game.openGoatDoor();
            if (switchDoor) {
                game.switchDoor();
            }
            if (game.playerWins()) {
                gamesWon++;
            }
            gamesPlayed++;
        }

        if (switchDoor)
            System.out.println("Games won by switching door: " + gamesWon + " out of " + gamesPlayed);
        else
            System.out.println("Games won by not switching door: " + gamesWon + " out of " + gamesPlayed);
    }

    private static int randomSelectedDoor() {
        double random = Math.random();
        if (random < 0.33)
            return 3;
        else if (random < 0.66)
            return 2;
        else
            return 1;
    }
}
