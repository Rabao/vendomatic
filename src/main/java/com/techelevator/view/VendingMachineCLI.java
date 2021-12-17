package com.techelevator.view;

import java.util.*;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,
			MAIN_MENU_OPTION_EXIT };

	private final Menu menu;
	private final Inventory inventory;
	private Purchase purchase;

	public VendingMachineCLI() {
		this.menu = new Menu(System.in, System.out);
		this.inventory = new Inventory();
		this.purchase = new Purchase(inventory);
		// Inventory object is created
	}

	public void run() {
		inventory.setProductList(); // 4. The vending machine is automatically restocked each time the application runs.
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			switch (choice) {
				case MAIN_MENU_OPTION_DISPLAY_ITEMS:
					// display vending machine items
					purchase.displayPurchaseOptions(inventory);
					break;
				case MAIN_MENU_OPTION_PURCHASE:
					// do purchase
					//6. The customer is brought to the purchase menu.
					purchase.purchaseMenuOptions();
					break;
				case MAIN_MENU_OPTION_EXIT:
					System.exit(0);
			}
		}
	}
}
