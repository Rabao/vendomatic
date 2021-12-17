package com.techelevator.view;

import java.util.HashMap;

public class Selection extends Purchase{
    private String slotInput;
    private String productSlot;
    private String productType;
    private double productPrice;
    private int productQty;
    DollarCalculator global;

    public Selection(Inventory inventory) {
        super(inventory);
    }

    public HashMap<String, Product> getProductMap(Inventory inventory) {
        /**HashMap used to store and navigate the product list.
         *Stores the list in a Hashmap in order to track selections with K/V pair*/
        HashMap<String, Product> products = new HashMap<>();
        for (Product prod : inventory.getProductList()) {
            products.put(prod.getSlotId(), prod);
        }
        return products;
    }

    public void getPurchaseMenu(Inventory inventory, DollarCalculator money){
        /**7.ii. Shows the list of products available; records the customers slot selection
         * in a variable for comparison and sets the product attributes.*/
        displayPurchaseOptions(inventory);
        try {
            slotInput = super.getSlotIdChoice().toUpperCase();

            productType = getProductMap(inventory).get(slotInput).getType();
            productPrice = getProductMap(inventory).get(slotInput).getPrice();
            productQty = getProductMap(inventory).get(slotInput).getQuantity();
            productSlot = getProductMap(inventory).get(slotInput).getSlotId();

        }catch(Exception e){
            //7.ii.If the product code does not exist, the customer is informed and returned to the purchase menu
            System.err.println("\n*** Product at " + slotInput + " does not exist. Please input valid slot number. ***\n");
            setBalance(money);
            this.purchaseMenuOptions();
        }
    }

    public void purchaseSelection(Inventory inventory, DollarCalculator money){
        getPurchaseMenu(inventory, money);
        double moneyInput = money.getDollar();

        if(productSlot.equals(slotInput) && moneyInput >= productPrice){

            /**7.ii. If a valid product is selected and is in stock, it is dispensed; reduces the
             * product quantity and stores the money that is currently deposited in the vending machine,
             * less the item's price.*/
            if(productQty > 0) {
                getProductMap(inventory).get(slotInput).setQuantity(productQty - 1);
                DollarCalculator deposit = money;
                DollarCalculator newBalance = money.subtract(getProductMap(inventory).get(slotInput).getPrice());

                //7.ii. Successful purchase flavor text; prints based on the item type
                if(productType.equals("Chip"))
                    System.out.println("\nCrunch Crunch, Yum!\n");
                else if(productType.equals("Candy"))
                    System.out.println("\nMunch Munch, Yum!\n");
                else if(productType.equals("Drink"))
                    System.out.println("\nGlug Glug, Yum!\n");
                else if(productType.equals("Gum"))
                    System.out.println("\nChew Chew, Yum!\n");

                setBalance(newBalance);
                logger.log(getProductMap(inventory).get(slotInput).getName(),deposit, getBalance());

            } else{
                //7.ii. If a product is sold out, the customer is informed and returned to the purchase menu.
                System.err.println("\nProduct at " + slotInput + " is out of stock.\n");
                setBalance(money);
            }
            this.purchaseMenuOptions();
        }
        else if(productSlot.equals(slotInput) && moneyInput < productPrice) {
            // Displays "insufficient funds" if trying to purchase with less than required amount deposited
            System.err.println("\nInsufficient funds.\n");
            setBalance(money);
            this.purchaseMenuOptions();
        }
    }
}
