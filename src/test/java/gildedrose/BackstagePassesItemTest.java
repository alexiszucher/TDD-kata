package gildedrose;

import gildedrose.item.BackstagePassesItem;
import gildedrose.item.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackstagePassesItemTest {
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    @Test
    void givenBackstagePassesItem_whenExpirationDateIsNotExpiredYet_shouldIncreaseQualityByOneAndDecreaseExpirationDateByOne() {
        Item[] items = new Item[] { new BackstagePassesItem(BACKSTAGE_PASSES, 100, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemHas(app.items[0], 99, 31);
    }

    @Test
    void givenBackstagePassesItem_whenExpirationDateIsLessThan10DaysAndMoreThan5Days_shouldIncreaseQualityByTwoAndDecreaseExpirationDateByOne() {
        Item[] items = new Item[] { new BackstagePassesItem(BACKSTAGE_PASSES, 7, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemHas(app.items[0], 6, 32);
    }

    @Test
    void givenBackstagePassesItem_whenExpirationDateIsEqualOrLessThan5Days_shouldIncreaseQualityByThreeAndDecreaseExpirationDateByOne() {
        Item[] items = new Item[] { new BackstagePassesItem(BACKSTAGE_PASSES, 5, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemHas(app.items[0], 4, 33);
    }

    @Test
    void givenBackstagePassesWithQuality50_whenUpdateQuality_shouldNotBeUpTo50() {
        Item[] items = new Item[] { new BackstagePassesItem(BACKSTAGE_PASSES, 100, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemHas(app.items[0], 99, 50);
    }

    @Test
    void givenBackstagePassesItem_whenItemIsExpired_shouldQualityBe0() {
        Item[] items = new Item[] { new BackstagePassesItem(BACKSTAGE_PASSES, -1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertItemHas(app.items[0], -2, 0);
    }

    private void assertItemHas(Item item, int sellIn, int quality) {
        assertEquals(sellIn, item.sellIn());
        assertEquals(quality, item.quality());
    }
}
