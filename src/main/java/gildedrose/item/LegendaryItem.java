package gildedrose.item;

public class LegendaryItem extends Item {
    public LegendaryItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        // Nothing to do with Legendary item.
    }
}
