package com.techelevator.view;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {
    private Product product;

    @Before
    public void setUp() throws Exception {
        product = new Product("D3","Crunchie",1.75,"Candy",5);
    }

    @Test
    public void getSlotId() {
        String slotId = product.getSlotId();

        assertEquals("D3",slotId);
        assertFalse("#3",false);
        assertFalse("D33",false);
    }

    @Test
    public void setSlotId() {
        product.setSlotId("D5");

        String slotId = product.getSlotId();

        assertEquals("D5",slotId);
        assertFalse("D3",false);
    }

    @Test
    public void getName() {
        String productName = product.getName();

        assertEquals("Crunchie",productName);
        assertFalse("Crunchiee",false);
    }

    @Test
    public void setName() {
        product.setName("Twix");

        String productName = product.getName();

        assertEquals("Twix",productName);
        assertFalse("Crunchie",false);
    }

    @Test
    public void getType() {
        String productType = product.getType();
        assertEquals("Candy",productType);
        assertFalse("Chip",false);
    }

    @Test
    public void setType() {
        product.setType("Chip");

        String productType = product.getType();

        assertEquals("Chip",productType);
        assertFalse("Candy",false);
    }

    @Test
    public void getPrice() {
        double getPrice = product.getPrice();

        assertEquals(1.75,getPrice,0.0);
        assertFalse("2.00",false);
    }

    @Test
    public void setPrice() {
        product.setPrice("2.00");

        double price = product.getPrice();

        assertEquals(2.00,price,0.0);
        assertFalse("1.75",false);
    }

    @Test
    public void getQuantity() {
        double qty = product.getQuantity();

        assertEquals(5,qty,0.0);
        assertFalse("4",false);
    }

    @Test
    public void setQuantity() {
        product.setQuantity(10);

        double newQuantity = product.getQuantity();

        assertEquals(10,newQuantity,0.0);
    }

    @Test
    public void isOutOfStock() {
        product.setQuantity(0);
        assertEquals("SOLD OUT",product.isOutOfStock());
        assertFalse("5",false);
    }
}