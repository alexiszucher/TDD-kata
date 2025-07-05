package gildedrose.item;

public abstract class Item {
    protected String name;

    protected int sellIn;

    protected int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public boolean hasQuality() {
        return quality > 0;
    }

    public boolean hasMaxQuality() {
        return quality >= 50;
    }

    public void decreaseQualityBy(int numberToDecrease) {
        if (this.hasQuality()) {
            quality -= numberToDecrease;
        }
    }

    public void increaseQualityBy(int numberToIncrease) {
        if (!this.hasMaxQuality()) {
            quality += numberToIncrease;
        }
    }

    public boolean isExpired() {
        return sellIn < 0;
    }

    abstract public void updateQuality();

    public String name() {
        return name;
    }

    public int quality() {
        return quality;
    }

    public int sellIn() {
        return sellIn;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
