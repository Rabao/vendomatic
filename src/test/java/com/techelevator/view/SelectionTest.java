package com.techelevator.view;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class SelectionTest extends TestCase {

    private Inventory inventory;
    private Selection newSelection;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        inventory = new Inventory();
        inventory.setProductList();
        newSelection = new Selection(inventory);
    }

    @Test
    public void testGetProductMap() {
        assertNotNull(newSelection.getProductMap(inventory));
        System.out.println(newSelection.getProductMap(inventory));
    }
}