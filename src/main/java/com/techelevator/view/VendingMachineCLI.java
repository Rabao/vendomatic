package com.techelevator.view;

import com.techelevator.util.VendorLog;

import java.util.*;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH = "Finish Transaction";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,
			MAIN_MENU_OPTION_EXIT };
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
			PURCHASE_MENU_OPTION_SELECT, PURCHASE_MENU_OPTION_FINISH };


	private final Menu menu;
	private final Inventory inventory;
	private DollarCalculator balance;

	public VendingMachineCLI() {
		this.menu = new Menu(System.in, System.out);
		this.inventory = new Inventory(); // Inventory object is created
		this.balance = new DollarCalculator(0); // DollarCalculator object is created
	}

	public void run() {
		inventory.setProductList(); // 4. The vending machine is automatically restocked each time the application runs.
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			switch (choice) {
				case MAIN_MENU_OPTION_DISPLAY_ITEMS:
					// display vending machine items
					displayPurchaseOptions();
					break;
				case MAIN_MENU_OPTION_PURCHASE:
					// do purchase
					//6. The customer is brought to the purchase menu.
					purchaseMenuOptions();
					break;
				case MAIN_MENU_OPTION_EXIT:
					System.exit(0);
			}
		}
	}

	public void purchaseMenuOptions(){

		while(true) {
			System.out.println();
			System.out.println("Current balance: " + balance);
			String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
			//7.i.Money currently deposited in the vending machine
//			System.out.println("\nCurrent Money Provided: " + moneyFormat.format((long) balance) + "\n");

			//HashMap used to store and navigate the product list.
			HashMap<String, Product> products = new HashMap<>();

			//Store list in Hashmap in order to track selections with K/V pair
			for (Product prod : inventory.getProductList()) {
				products.put(prod.getSlotId(), prod);
			}

			switch (choice) {
				case PURCHASE_MENU_OPTION_FEED_MONEY:
					//7.i. Allows the customer to feed money to the machine in whole dollar amounts.
					int moneyFeed = menu.getMoneyFeedFromUser();
					Calculator addToBalance = new DollarCalculator(moneyFeed * 100);
					balance = balance.add(addToBalance);
					VendorLog.log("FEED MONEY", balance, balance);

					break;
				case PURCHASE_MENU_OPTION_SELECT:
					//7.ii. Shows the list of products available; records the customers slot selection in a variable
					// for comparison.
					displayPurchaseOptions();
					String slotInput = menu.getSlotIdChoice().toUpperCase();

					if (inventory.getProductList().stream().anyMatch(str -> str.getSlotId().equals(slotInput))
							&& balance.getDollar() >= products.get(slotInput).getPrice()) {
						//7.ii. If a valid product is selected and is in stock, it is dispensed
						if (products.get(slotInput).getQuantity() > 0) {
							//7.ii. Reduces product quantity
							products.get(slotInput).setQuantity(products.get(slotInput).getQuantity() - 1);
							//7.ii. Money currently deposited in the vending machine, less the item price
							//save deposit amount before updating new balance
							DollarCalculator deposit = balance;
							DollarCalculator newBalance = balance.subtract(products.get(slotInput).getPrice());

							//7.ii. Successful purchase flavor text; prints based on the item type
							if (products.get(slotInput).getType().equals("Chip"))
								System.out.println("\nCrunch Crunch, Yum!\n");
							else if (products.get(slotInput).getType().equals("Candy"))
								System.out.println("\nMunch Munch, Yum!\n");
							else if (products.get(slotInput).getType().equals("Drink"))
								System.out.println("\nGlug Glug, Yum!\n");
							else if (products.get(slotInput).getType().equals("Gum"))
								System.out.println("\nChew Chew, Yum!\n");

							balance = newBalance;
							VendorLog.log(inventory.getProductBySlotId(slotInput), deposit, balance);

						} else {
							//7.ii. If a product is sold out, the product name becomes "SOLD OUT" to indicate OOS
							products.get(slotInput).setName("SOLD OUT");
							//7.ii. If a product is sold out, the customer is informed and returned to the purchase menu
							System.err.println("\nProduct at " + slotInput + " is out of stock.\n");
						}
						purchaseMenuOptions();

					} else if (inventory.getProductList().stream().anyMatch(str -> str.getSlotId().equals(slotInput)
							&& balance.getDollar() < products.get(slotInput).getPrice())) {
						// Displays "insufficient funds" if trying to purchase with less than required amount deposited
						System.err.println("\nInsufficient funds.\n");
						purchaseMenuOptions();

					}//7.ii.If the product code does not exist, the customer is informed and returned to the purchase menu
					else if (inventory.getProductList().stream().noneMatch(str -> str.getSlotId().equals(slotInput))) {
						System.err.println("\nProduct at " + slotInput + " does not exist. Please input valid slot number.\n");
						run();
					}
					break;
				case PURCHASE_MENU_OPTION_FINISH:
					DollarCalculator amountToReturn = balance;
					amountToReturn.returnChange();
					balance = new DollarCalculator(0);
					VendorLog.log("GIVE CHANGE", amountToReturn, balance);
					run();
					break;
			}
		}
	}

	public void displayPurchaseOptions(){
		System.out.println("Slot " + " Product " + "             Price " + "     Type " + "     Qty");
		inventory.displayInventoryProducts();
	}
}
