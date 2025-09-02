package mountyhall;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {
    @Test
    void shouldSelectADoor() {
        Player player = new Player();
        player.selectDoor(1);
        Assertions.assertEquals(1, player.selectedDoor());

        player.selectDoor(2);
        Assertions.assertEquals(2, player.selectedDoor());
    }
}