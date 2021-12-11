package com.techelevator;

import com.techelevator.view.Inventory;
import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	private final Menu menu;
	private final Inventory inventory;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
		this.inventory = new Inventory(); // Inventory object is created
	}

	public void run() {

		inventory.setProductList(); // 4. The vending machine is automatically restocked each time the application runs.

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				System.out.println("Slot " + " Product " + "             Price " + "     Type " + "     Qty");
				inventory.displayInventoryProducts();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase

			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)){
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();

	}
}
