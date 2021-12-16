package com.techelevator.view;

public class ReturnChange {
    private int totalCents = 0;
    private int totalNickels = 0;
    private int totalDimes = 0;
    private int totalQuarters = 0;

    public int getTotalCents() {
        return totalCents;
    }

    public int getTotalNickels() {
        return totalNickels;
    }

    public int getTotalDimes() {
        return totalDimes;
    }

    public int getTotalQuarters() {
        return totalQuarters;
    }

    public void calculateChange(double deposited){
        double balance = deposited*100; //Deposited money converted to pennies.
        this.totalCents = (int)balance;

        while (this.totalCents > 0){
            if(this.totalCents >= 25){
                this.totalQuarters +=1;
                this.totalCents-= 25;
            } else if(this.totalCents >= 10){
                this.totalDimes += 1;
                this.totalCents -= 10;
            } else if(totalCents >= 5){
                this.totalNickels += 1;
                this.totalCents-= 5;
            }
        }
    }

}
