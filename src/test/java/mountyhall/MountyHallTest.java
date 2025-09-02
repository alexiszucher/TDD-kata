package mountyhall;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MountyHallTest {
    private List<Door> doors;

    @BeforeEach
    void setup() {
        doors = List.of(
                Door.buildWithGoat(),
                Door.buildWithGoat(),
                Door.buildWithCar()
        );
    }

    @Test
    void shouldContainThreeDoorsClosed() {
        MountyHall game = new MountyHall(doors, new Player());
        Assertions.assertEquals(3, game.doors().size());
        Assertions.assertTrue(game.doors().get(0).isClosed());
        Assertions.assertTrue(game.doors().get(1).isClosed());
        Assertions.assertTrue(game.doors().get(2).isClosed());
    }

    @Test
    void shouldOpenAGoatDoor_andOpenedDoorMustNotBePlayerSelectedDoor() {
        MountyHall game = new MountyHall(doors, new Player());
        game.playerSelectDoor(1);
        game.openGoatDoor();
        Assertions.assertTrue(game.doorNumber(1).isClosed());
        Assertions.assertTrue(game.doorNumber(2).isOpened());
        Assertions.assertTrue(game.doorNumber(3).isClosed());
    }

    @Test
    void shouldPlayerCanSwitchDoorAfterAGoatDoorIsOpened() {
        MountyHall game = new MountyHall(doors, new Player());
        game.playerSelectDoor(1);
        game.openGoatDoor();
        game.switchDoor();
        Assertions.assertEquals(3, game.selectedDoor());
    }

    @Test
    void shouldPlayerCannotSwitchDoorWhenAllDoorsAreClosed() {
        MountyHall game = new MountyHall(doors, new Player());
        game.playerSelectDoor(1);
        Assertions.assertThrows(IllegalStateException.class, game::switchDoor);
    }

    @Test
    void shouldDoorsBeRevealedAndPlayerWinACar() {
        MountyHall game = new MountyHall(doors, new Player());
        game.playerSelectDoor(1);
        game.openGoatDoor();
        game.switchDoor();
        Assertions.assertTrue(game.playerWins());
    }

    @Test
    void shouldDoorsBeRevealedAndPlayerLoose() {
        MountyHall game = new MountyHall(doors, new Player());
        game.playerSelectDoor(1);
        game.openGoatDoor();
        Assertions.assertFalse(game.playerWins());
    }
}