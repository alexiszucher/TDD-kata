package shoppingbasket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {
    private static final List<Item> ITEMS = List.of(Item.of("Orange", 4, 8.5), Item.of("Oignon", 8, 2));
    private static final List<Item> ITEMS_WITH_TOTAL_MORE_THAN_100$ = List.of(
            Item.of("Ring", 1, 110)
    );
    private static final List<Item> ITEMS_WITH_TOTAL_MORE_THAN_200$ = List.of(
            Item.of("Ring", 1, 220)
    );
    private static final List<Item> ITEMS_WITH_TOTAL_MORE_THAN_250$ = List.of(
            Item.of("Ring", 1, 260)
    );

    @Test
    void shouldFindQuantityOfItem() {
        Basket basket = new Basket(ITEMS);
        int quantityOfOrange = basket.findQuantityFor("Orange");
        assertEquals(4, quantityOfOrange);
    }

    @Test
    void shouldComputeTotalPrice() {
        Basket basket = new Basket(ITEMS);
        assertEquals(50, basket.totalPrice());
    }

    @Test
    void givenTotalPriceIsMoreThan100$_shouldApplyDiscountOf5percent() {
        Basket basket = new Basket(ITEMS_WITH_TOTAL_MORE_THAN_100$);
        assertEquals(104.5, basket.totalPrice());
    }

    @Test
    void givenTotalPriceIsMoreThan200$_shouldApplyDiscountOf10percent() {
        Basket basket = new Basket(ITEMS_WITH_TOTAL_MORE_THAN_200$);
        assertEquals(198, basket.totalPrice());
    }

    @Test
    void givenTotalPriceIsMoreThan250$_shouldApplyDiscountOf15percent() {
        Basket basket = new Basket(ITEMS_WITH_TOTAL_MORE_THAN_250$);
        assertEquals(221, basket.totalPrice());
    }
}