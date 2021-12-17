package com.techelevator.view;

import com.techelevator.util.VendorLog;
import java.util.*;
public class Purchase extends Menu {
    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
            PURCHASE_MENU_OPTION_SELECT, PURCHASE_MENU_OPTION_FINISH };

    private Inventory inventory;
    private DollarCalculator balance;
    private VendingMachineCLI vend;
    private Selection buy;

    VendorLog logger = new VendorLog();

    public Purchase(Inventory inventory){
        super(System.in, System.out); //Passes system input and output to parent class
        this.inventory = inventory;
        this.balance = new DollarCalculator(0); // DollarCalculator object is created
    }

    public DollarCalculator getBalance() {
        return balance;
    }

    public void setBalance(DollarCalculator balance) {
        this.balance = balance;
    }

    public void displayPurchaseOptions(Inventory inventory){
        System.out.println("Slot " + " Product " + "             Price " + "     Type " + "     Qty");
        inventory.displayInventoryProducts();
    }

    public void purchaseMenuOptions() {
        while (true) {
            String choice = (String) super.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
            System.out.println("\nCurrent balance: " + balance + " \n");
            buy = new Selection(inventory);

            switch (choice) {
                case PURCHASE_MENU_OPTION_FEED_MONEY:
                    /**7.i. Allows the customer to feed money to the machine in whole dollar amounts.
                     * Logs the money fed into the machine as well as the balance of money already
                     * deposited to the machine.*/
                    int moneyFeed = super.getMoneyFeedFromUser();
                    Calculator addToBalance = new DollarCalculator(moneyFeed * 100);
                    this.balance = this.balance.add(addToBalance);
                    logger.log("FEED MONEY", balance, balance);
                    break;

                case PURCHASE_MENU_OPTION_SELECT:
                    while (true) {
                        /**6. Brings the Customer to the purchase menu. */
                        buy.purchaseSelection(inventory, balance);
                        break;
                    }

                case PURCHASE_MENU_OPTION_FINISH:
                    DollarCalculator amountToReturn = balance;
                    amountToReturn.returnChange();
                    balance = new DollarCalculator(0);
                    VendorLog.log("GIVE CHANGE", amountToReturn, balance);
                    vend = new VendingMachineCLI();
                    vend.run();
                    break;
            }

        }
    }
}
