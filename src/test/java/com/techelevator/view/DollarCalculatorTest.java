package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DollarCalculatorTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getDollar() {
    }

    @Test
    public void getTotalAmountInCents() {
    }

    @Test
    public void returnChange() {
    }

    @Test
    public void subtract() {
    }

    @Test
    public void add() {
    }
    
    @Test
    public void string_format_test(){
        double moneyFeed = 10.15;
        DollarCalculator change = new DollarCalculator(0);
        Calculator addToBalance = new DollarCalculator(moneyFeed * 100);


        change = change.add(addToBalance);
        String toDollar = "$" + String.format("%.2f", change.getDollar());
        Assert.assertEquals("$10.15", toDollar);
    }

    @Test
    public void string_format_test_two(){
        double moneyFeed = 5.13;
        DollarCalculator change = new DollarCalculator(0);
        Calculator addToBalance = new DollarCalculator(moneyFeed * 100);


        change = change.add(addToBalance);
        String toDollar = "$" + String.format("%.2f", change.getDollar());
        Assert.assertEquals("$5.13", toDollar);
    }

    @Test
    public void string_format_test_three(){
        double moneyFeed = 100.49;
        DollarCalculator change = new DollarCalculator(0);
        Calculator addToBalance = new DollarCalculator(moneyFeed * 100);


        change = change.add(addToBalance);
        String toDollar = "$" + String.format("%.2f", change.getDollar());
        Assert.assertEquals("$100.49", toDollar);
    }

    @Test
    public void string_format_test_four(){
        double moneyFeed = 0.75;
        DollarCalculator change = new DollarCalculator(0);
        Calculator addToBalance = new DollarCalculator(moneyFeed * 100);


        change = change.add(addToBalance);
        String toDollar = "$" + String.format("%.2f", change.getDollar());
        Assert.assertEquals("$0.75", toDollar);
    }
}