package insideout;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PanierTest {
    @Test
    void shouldFailWhenThereAreNothingInThePanier() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Panier(List.of()));
    }

    @Test
    void shouldBuild() {
        Panier panier = new Panier(List.of(
                new Item("Tomate", 2),
                new Item("Croissant", 1),
                new Item("Salade", 4)));
    }

    @Test
    void shouldComputeTotalPrice() {
        Panier panier = new Panier(List.of(
                new Item("Tomate", 2),
                new Item("Croissant", 1),
                new Item("Salade", 4)
        ));
        Assertions.assertEquals(7, panier.prixTotal());

        panier = new Panier(List.of(
                new Item("Tomate", 2),
                new Item("Croissant", 1)
        ));
        Assertions.assertEquals(3, panier.prixTotal());
    }
}
