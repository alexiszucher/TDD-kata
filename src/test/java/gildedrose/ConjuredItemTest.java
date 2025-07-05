package gildedrose;

import gildedrose.item.ConjuredItem;
import gildedrose.item.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredItemTest {
    public static final String CONJURED_ITEM = "Conjured Mana Cake";

    @Test
    void givenConjuredItem_whenExpirationDateIsNotExpired_shouldQualityDecreaseByTwoAndExpirationDateByOne() {
        Item[] items = new Item[] { new ConjuredItem(CONJURED_ITEM, 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemHas(app.items[0], 4, 8);
    }

    @Test
    void givenConjuredItem_whenExpirationDateIsExpired_shouldQualityDecreaseByFourAndExpirationDateByOne() {
        Item[] items = new Item[] { new ConjuredItem(CONJURED_ITEM, -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemHas(app.items[0], -2, 6);
    }

    private void assertItemHas(Item item, int sellIn, int quality) {
        assertEquals(sellIn, item.sellIn());
        assertEquals(quality, item.quality());
    }
}
