package insideout;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {
    @Test
    void shouldBuildItem() {
        Item item = new Item("Tomate", 2);
        Assertions.assertEquals("Tomate", item.name());
        Assertions.assertEquals(2, item.price());
    }

    @Test
    void shouldNotBuildItemWhenThereAreNoPrice() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Item("Tomate", 0));
    }
}
