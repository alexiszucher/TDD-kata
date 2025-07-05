package gildedrose.item;

public class AgedBrieItem extends Item {
    public AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        this.sellIn = this.sellIn - 1;
        if (this.isExpired()) {
            increaseQualityBy(2);
        } else {
            increaseQualityBy(1);
        }
    }
}
