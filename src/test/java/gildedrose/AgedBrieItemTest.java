package gildedrose;

import gildedrose.item.AgedBrieItem;
import gildedrose.item.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieItemTest {
    public static final String AGED_BRIE = "Aged Brie";

    @Test
    void givenAgedBrieItem_whenExpirationDateIsNotExpiredYet_shouldIncreaseQualityByOneAndDecreaseExpirationDateByOne() {
        Item[] items = new Item[] { new AgedBrieItem(AGED_BRIE, 100, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemHas(app.items[0], 99, 31);
    }

    @Test
    void givenAgedBrieItem_whenExpirationDateIsExpired_shouldIncreaseQualityByTwoAndDecreaseExpirationDateByOne() {
        Item[] items = new Item[] { new AgedBrieItem(AGED_BRIE, -1, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemHas(app.items[0], -2, 32);
    }

    @Test
    void givenAgedBrieWithQuality50_whenUpdateQuality_shouldNotBeUpTo50() {
        Item[] items = new Item[] { new AgedBrieItem(AGED_BRIE, 100, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemHas(app.items[0], 99, 50);
    }

    private void assertItemHas(Item item, int sellIn, int quality) {
        assertEquals(sellIn, item.sellIn());
        assertEquals(quality, item.quality());
    }
}
