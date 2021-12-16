package com.techelevator.view;

public class DollarCalculator implements Calculator{

    private final double totalAmountInCents;

    public DollarCalculator(double totalAmountInCents) {
        this.totalAmountInCents = totalAmountInCents;
    }

    @Override
    public double getDollar() {
        return totalAmountInCents / 100;
    }

    @Override
    public double getTotalAmountInCents() {
        return totalAmountInCents;
    }


    @Override
    public void returnChange() {
        double totalCents = getTotalAmountInCents();
        int totalNickels = 0;
        int totalDimes = 0;
        int totalQuarters = 0;

        while (totalCents > 0){
            if (totalCents >= 25){
                totalQuarters ++;
                totalCents-= 25;
            }else if (totalCents >= 10){
                totalDimes++;
                totalCents-= 10;
            }else if (totalCents >= 5){
                totalNickels++;
                totalCents-= 5;
            }
        }
        System.out.println("Change: " + totalQuarters + " quarter(s), " + totalDimes + " dime(s), " + totalNickels + " nickel(s), " );
        System.out.println("*****************************************");
        System.out.println("************  THANK YOU!  ***************");
        System.out.println("*****************************************");
    }

    public DollarCalculator subtract(double amountSubtracted){
        return new DollarCalculator(this.totalAmountInCents - amountSubtracted * 100);
    }

    public DollarCalculator add(Calculator amountAdded){
        return new DollarCalculator(this.totalAmountInCents + amountAdded.getTotalAmountInCents());
    }

    public String toString() {
        return "$" + String.format("%.2f", getDollar());
    }

}
