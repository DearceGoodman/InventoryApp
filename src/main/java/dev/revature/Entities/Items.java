package dev.revature.Entities;

import java.util.Objects;

public class Items {
    private int itemNumber;
    private String itemName;
    private int expirationDate;
    private int productSize;
    private String itemLocation;
    private String itemType;
    private int stockAmount;

    public Items(){}

    public Items(int itemNumber, String itemName, int expirationDate, int productSize, String itemLocation, String itemType, int stockAmount) {
        this.itemNumber = itemNumber;
        this.itemName = itemName;
        this.expirationDate = expirationDate;
        this.productSize = productSize;
        this.itemLocation = itemLocation;
        this.itemType = itemType;
        this.stockAmount = stockAmount;
    }

    @Override
    public String toString() {
        return "Items{" +
                "itemNumber=" + itemNumber +
                ", itemName='" + itemName + '\'' +
                ", expirationDate=" + expirationDate +
                ", productSize=" + productSize +
                ", itemLocation='" + itemLocation + '\'' +
                ", itemType='" + itemType + '\'' +
                ", stockAmount=" + stockAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Items items = (Items) o;
        return itemNumber == items.itemNumber && expirationDate == items.expirationDate && productSize == items.productSize && stockAmount == items.stockAmount && Objects.equals(itemName, items.itemName) && Objects.equals(itemLocation, items.itemLocation) && Objects.equals(itemType, items.itemType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemNumber, itemName, expirationDate, productSize, itemLocation, itemType, stockAmount);
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(int expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getProductSize() {
        return productSize;
    }

    public void setProductSize(int productSize) {
        this.productSize = productSize;
    }

    public String getItemLocation() {
        return itemLocation;
    }

    public void setItemLocation(String itemLocation) {
        this.itemLocation = itemLocation;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }
}
