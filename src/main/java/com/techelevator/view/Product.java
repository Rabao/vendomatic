package com.techelevator.view;


import java.text.NumberFormat;

public class Product {
    private String slotId;
    private String name;
    private double price;
    private String type;
    private int quantity;
    NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();

    public Product(){};

    public Product(String slotId, String name, double price, String type, int quantity) {
        this.slotId = slotId;
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = Double.parseDouble(price);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String isOutOfStock(){
        return quantity == 0 ? "SOLD OUT" : Integer.toString(quantity);
    }
    /**
     * @return a formatted string: padding is applied between
     * each column to align the properties of each product.
     */
    public String toString(){
        return String.format("%1$-5s %2$-20s %3$-10s %4$-9s %5$-4s", slotId,name,moneyFormat.format(price),type,isOutOfStock());
    }
}
