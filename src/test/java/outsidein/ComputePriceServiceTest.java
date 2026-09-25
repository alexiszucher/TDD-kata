package outsidein;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ComputePriceServiceTest {
    @Test
    void shouldFailWhenIHaveNothingInMyPanier() {
        ComputePriceService computeService = new ComputePriceService();
        Assertions.assertThrows(IllegalArgumentException.class, () -> computeService.totalPrice(List.of(), false));
    }

    @Test
    void shouldComputeTotalPriceOfMyPanier() {
        ComputePriceService computeService = new ComputePriceService();
        Assertions.assertEquals(8, computeService.totalPrice(List.of(
                new ItemRequest("Tomate", 2),
                new ItemRequest("Croissant", 1),
                new ItemRequest("Salade", 5)
        ), false));

        Assertions.assertEquals(7, computeService.totalPrice(List.of(
                new ItemRequest("Tomate", 2),
                new ItemRequest("Salade", 5)
        ), false));
    }

    @Test
    void shouldHave10PercentOfReductionWhenThePriceIsOver100() {
        ComputePriceService computeService = new ComputePriceService();
        Assertions.assertEquals(100, computeService.totalPrice(List.of(
                new ItemRequest("Barbecue", 100)
        ), false));
        Assertions.assertEquals(90, computeService.totalPrice(List.of(
                new ItemRequest("Barbecue", 101)
        ), false));
    }

    @Test
    void shouldHave5PercentMoreOfReductionWhenTheCustomerIsFidele() {
        ComputePriceService computeService = new ComputePriceService();
        Assertions.assertEquals(95, computeService.totalPrice(List.of(
                new ItemRequest("Barbecue", 100)
        ), true));
        Assertions.assertEquals(85, computeService.totalPrice(List.of(
                new ItemRequest("Barbecue", 101)
        ), true));
    }
}
