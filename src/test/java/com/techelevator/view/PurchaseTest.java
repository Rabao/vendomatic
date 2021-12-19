package com.techelevator.view;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;



public class PurchaseTest extends TestCase {

    Inventory inventory;
    Purchase purchase;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        inventory = new Inventory();
        inventory.setProductList();
        purchase = new Purchase(inventory);
    }

    @Test
    public void testSetAndGetBalance() {
        DollarCalculator expected = new DollarCalculator(900);
        DollarCalculator actualDC = new DollarCalculator(1500);
        DollarCalculator newBalance = actualDC.subtract(6.0);

        Purchase actual = new Purchase(inventory);

        actual.setBalance(newBalance);

        assertEquals(expected.getDollar(), actual.getBalance().getDollar());
        System.out.println("Expected: " + expected.getDollar() + " Actual: " + actual.getBalance().getDollar());
    }

    @Test
    public void testDisplayPurchaseOptions() {
        purchase.displayPurchaseOptions(inventory);
    }

}
