package gildedrose.item;

public class BackstagePassesItem extends Item {
    public BackstagePassesItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        this.sellIn = this.sellIn - 1;
        if (isEqualOrLessThan10DaysAndMoreThan5Days()) {
            increaseQualityBy(2);
        } else if (isEqualOrLessThan5DaysAndNotExpired()) {
            increaseQualityBy(3);
        } else if (isExpired()){
            quality = 0;
        } else {
            increaseQualityBy(1);
        }
    }

    private boolean isEqualOrLessThan5DaysAndNotExpired() {
        return sellIn <= 5 && sellIn > 0;
    }

    private boolean isEqualOrLessThan10DaysAndMoreThan5Days() {
        return sellIn <= 10 && sellIn > 5;
    }
}
