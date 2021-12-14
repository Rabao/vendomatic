package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {

	private PrintWriter out;
	private Scanner in;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if (choice == null) {
			out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print(System.lineSeparator() + "Please choose an option >>> ");
		out.flush();
	}

	/**
	 * @return an integer. While choice is equal to null
	 * prompt the user to insert the denomitation required
	 * to successfully feed money into the vending machine.
	 * Check if the money inserted by the user is the
	 * correct denomination, otherwise alert invalid input
	 *
	 */
	public Integer getMoneyFeedFromUser() {

		Integer choice = null;

		while (choice == null) {
			out.println("Please insert $1, $2, $5, $10, or $20");
			out.flush();
			String userInput = in.nextLine();

			if (userInput.equals("1") || userInput.equals("2") || userInput.equals("5") || userInput.equals("10")) {
				choice = Integer.parseInt(userInput);
			} else {
				out.println("\n*** " + userInput + " is not a valid input ***\n");
				out.flush();
			}
		}
		return choice;
	}

	public String getProductSlotId() {
		String choice = null;

		while (choice == null) {
			out.println("Please enter your selection");
			out.flush();
			String userInput = in.nextLine();
			if (userInput.length() > 0) {
				choice = userInput;
			} else {
				out.println("\n*** " + userInput + " is not a valid option ***\n");
				out.flush();
			}
		}
		return choice;
	}

}
