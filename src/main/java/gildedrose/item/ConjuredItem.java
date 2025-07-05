package gildedrose.item;

public class ConjuredItem extends Item {
    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        this.sellIn = this.sellIn - 1;
        if (this.isExpired()) {
            decreaseQualityBy(4);
        } else {
            decreaseQualityBy(2);
        }
    }
}
