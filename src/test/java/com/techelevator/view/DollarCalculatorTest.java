package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DollarCalculatorTest {

    DollarCalculator change = new DollarCalculator(57350);
    double totalCents;

    @Before
    public void setUp() throws Exception {
        totalCents = change.getTotalAmountInCents();
    }

    @Test
    public void getDollar() {
        change.getDollar();
        assertEquals(573.50, change.getDollar(),0);
    }

    @Test
    public void getTotalAmountInCents() {
        change.getTotalAmountInCents();
        assertEquals(57350, change.getTotalAmountInCents(),0);
    }

    @Test
    public void returnChange() {
        //Test to see if returnChange() returns the expected text.
        change.returnChange();
    }

    @Test
    public void subtract() {
        double amountSubtracted = 286.75;

        change = change.subtract(amountSubtracted);
        assertEquals(28675,change.getTotalAmountInCents(),0);
    }

    @Test
    public void add_test() {
        double moneyFeed = 573.50;
        DollarCalculator change = new DollarCalculator(0);
        double preAdd = change.getTotalAmountInCents();
        Calculator addToBalance = new DollarCalculator(moneyFeed * 100);

        change = change.add(addToBalance);
        assertEquals(57350,change.getTotalAmountInCents(),0);
    }

    @Test
    public void string_format_test_two(){
        double moneyFeed = 5.13;
        DollarCalculator change = new DollarCalculator(0);
        Calculator addToBalance = new DollarCalculator(moneyFeed * 100);


        change = change.add(addToBalance);
        String toDollar = "$" + String.format("%.2f", change.getDollar());
        assertEquals("$5.13", toDollar);
    }

    @Test
    public void string_format_test_three(){
        double moneyFeed = 100.49;
        DollarCalculator change = new DollarCalculator(0);
        Calculator addToBalance = new DollarCalculator(moneyFeed * 100);


        change = change.add(addToBalance);
        String toDollar = "$" + String.format("%.2f", change.getDollar());
        assertEquals("$100.49", toDollar);
    }

    @Test
    public void string_format_test_four(){
        double moneyFeed = 0.75;
        DollarCalculator change = new DollarCalculator(0);
        Calculator addToBalance = new DollarCalculator(moneyFeed * 100);


        change = change.add(addToBalance);
        String toDollar = "$" + String.format("%.2f", change.getDollar());
        assertEquals("$0.75", toDollar);
    }
}