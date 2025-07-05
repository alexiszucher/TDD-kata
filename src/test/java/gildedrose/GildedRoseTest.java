package gildedrose;

import gildedrose.item.CommonItem;
import gildedrose.item.Item;
import gildedrose.item.LegendaryItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String COMMON_ITEM = "Elixir of the Mongoose";

    @Test
    void givenLegendarySulfurasItem_shouldKeepSameQualityAndDoesntHaveExpirationDate() {
        Item[] items = new Item[] { new LegendaryItem(SULFURAS_HAND_OF_RAGNAROS, -1, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemHas(app.items[0], SULFURAS_HAND_OF_RAGNAROS, -1, 80);
    }

    @Test
    void givenCommonItem_whenExpirationDateIsExpired_shouldDecreaseQualityByTwoAndDecreaseExpirationDateByOne() {
        Item[] items = new Item[] { new CommonItem("Elixir of the Mongoose", -1, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemHas(app.items[0], COMMON_ITEM, -2, 28);
    }

    @Test
    void givenCommonItem_whenExpirationDateIsNotExpired_shouldDecreaseQualityByOneAndDecreaseExpirationDateByOne() {
        Item[] items = new Item[] { new CommonItem(COMMON_ITEM, 4, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemHas(app.items[0], COMMON_ITEM, 3, 29);
    }

    @Test
    void givenQualityAt0_shouldNotDecreaseQuality() {
        Item[] items = new Item[] { new CommonItem(COMMON_ITEM, 4, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemHas(app.items[0], COMMON_ITEM, 3, 0);
    }

    private void assertItemHas(Item item, String name, int sellIn, int quality) {
        assertEquals(name, item.name());
        assertEquals(sellIn, item.sellIn());
        assertEquals(quality, item.quality());
    }
}
