package com.techelevator.view;

public class Product {
    private String slotId;
    private String name;
    private String type;
    private double price;
    private int quantity;

    public Product(){};

    public Product(String slotId, String name, String type, int price, int quantity){{
}       this.slotId = slotId;
        this.name = name;
        this.type = type;
        this.price = price;
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
}
