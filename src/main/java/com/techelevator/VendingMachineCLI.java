package com.techelevator;

import com.techelevator.view.*;

public class VendingMachineCLI {


	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,
			MAIN_MENU_OPTION_EXIT };

	private final Menu menu;
	private final Inventory inventory;
	private PurchaseMenu purchase;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
		this.inventory = new Inventory(); // Inventory object is created
	}

	public void run() {
		inventory.setProductList(); // 4. The vending machine is automatically restocked each time the application runs.
		purchase = new PurchaseMenu(inventory);

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				purchase.displayPurchaseOptions(inventory);
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				while (true) {
					//6. The customer is brought to the purchase menu.
					purchase.purchaseMenuOptions();
				}
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)){
				System.exit(0);
			} else if(choice.equals(4)){
				System.out.println("Test");
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}