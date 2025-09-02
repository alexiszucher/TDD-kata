package mountyhall;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DoorTest {
    @Test
    void shouldContainAGoatOrACar() {
        Door doorWithGoat = Door.buildWithGoat();
        Assertions.assertTrue(doorWithGoat.hasGoat());
        Assertions.assertFalse(doorWithGoat.hasCar());

        Door doorWithCar = Door.buildWithCar();
        Assertions.assertFalse(doorWithCar.hasGoat());
        Assertions.assertTrue(doorWithCar.hasCar());
    }
}