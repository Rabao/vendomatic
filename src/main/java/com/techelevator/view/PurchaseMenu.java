package com.techelevator.view;

public class PurchaseMenu extends Menu{

    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
            PURCHASE_MENU_OPTION_SELECT, PURCHASE_MENU_OPTION_FINISH };
    private Inventory inventory;
    private static double deposited = 0;

    VendorLog logger = new VendorLog();
    Selection purchase;

    public PurchaseMenu(Inventory inventory){
        super(System.in, System.out); //Passes system input and output to parent class
        this.inventory = inventory;
    }

    public static double getDeposited() {
        return deposited;
    }

    public void purchaseMenuOptions(){

        String choice = (String) super.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
        purchase = new Selection(inventory);
        int moneyInput = 0;

        if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
            /**7.i. Allows the customer to feed money to the machine in whole dollar amounts.
             * Logs the money fed into the machine as well as the balance of money already
             * deposited to the machine.*/
            moneyInput = super.getMoneyFeedFromUser();
            deposited += moneyInput;
            logger.log("FEED MONEY",deposited,moneyInput);

        } else if (choice.equals(PURCHASE_MENU_OPTION_SELECT)) {
            while (true) {
                /**6. Brings the Customer to the purchase menu. */
                purchase.purchaseSelection(inventory,moneyInput);
            }

        } else if (choice.equals(PURCHASE_MENU_OPTION_FINISH)) {
            deposited = 0;
            setProvidedMoney(deposited);
        }
    }

    public void displayPurchaseOptions(Inventory inventory){
        System.out.println("Slot " + " Product " + "             Price " + "     Type " + "     Qty");
        inventory.displayInventoryProducts();
    }
}
