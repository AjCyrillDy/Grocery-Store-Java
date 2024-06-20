import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * Student Name: Aj Cyrill Dy
 * Student Number: 041113696
 * Section #: 311
 * Course: CST8130 - Data Structures
 * Author/Professor: Narges Tabar
 */

public class FoodItem {

	/*
	 * Declarations
	 */
	
	private int itemCode;
	private String itemName;
	private float itemPrice;
	private int itemQuantityInStock;
	private float itemCost;

	//No arg constructor
	public FoodItem() {
	}
	
	//Overloaded constructor
	public FoodItem(int itemCode, String itemName, float itemPrice, int itemQuantityInStock, float itemCost) {
		super();
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQuantityInStock = itemQuantityInStock;
		this.itemCost = itemCost;
	}


	// Method to update the quantity of a food item
	public boolean updateItem(int amount) {
		// If the amount is negative and the absolute value of the amount is greater than the quantity in stock
		if (amount <= 0 && Math.abs(amount) > itemQuantityInStock) {
			// Print an error message and return false
			System.out.println("Cannot update the quantity. Not enough items in stock.");
			return false;
		} else if (amount > 0 && amount > itemQuantityInStock) {
			System.out.println("Error: Cannot buy. Not enough items in stock.");
			return false;
		}
		// Otherwise, update the quantity in stock by the amount and return true
		itemQuantityInStock += amount;
		return true;
	}

	// Method to buy an item //**Don't really need this anymore since I fixed it in the updateQuantity method
	public boolean buyItem(int amount) {
		if (amount <= 0) { // If the amount is less than or equal to 0
			System.out.println("Error... could not buy item"); // Print an error message
			return false; // Return false
		}
		return updateItem(amount); // Update the quantity in stock and return the result
	}

	// Method to sell an item //**Don't really need this anymore since I fixed it in the updateQuantity method
	public boolean sellItem(int amount) {
		if (amount <= 0) { // If the amount is less than or equal to 0
			System.out.println("Error... could not sell item"); // Print an error message
			return false; // Return false
		}
		boolean result = updateItem(-amount); // Update the quantity in stock by subtracting the amount and store the result
		if (result) { // If the result is true
			System.out.println("Item sold successfully"); // Print a success message
		} else { // If the result is false
			System.out.println("Error... could not sell item"); // Print an error message
		}
		return result; // Return the result
	}

	// Method to check if two food items are equal
	public boolean isEqual(FoodItem item) {
		// If the item codes of the two items are equal, return true
		if (itemCode == item.itemCode) {
			return true;
		}
		// If the item codes are not equal, return false
		return false;
	}

	// Method to add an item
	public boolean addItem(Scanner scanner) {
		// Loop until a valid input is entered
		while (true) {
			try {
				// Prompt the user to enter the item code
				System.out.print("Enter the code for the item: <must be an int>: ");
				itemCode = scanner.nextInt(); // Read the item code
				scanner.nextLine(); // Consume the newline

				// Prompt the user to enter the item name
				System.out.print("Enter the name for the item: ");
				itemName = scanner.nextLine(); // Read the item name

				// Loop until a valid quantity is entered
				while (true) {
					// Prompt the user to enter the item quantity
					System.out.print("Enter the quantity for the item: ");
					if (!scanner.hasNextInt()) { // If the next input is not an integer
						System.out.println("Invalid entry"); // Print an error message
						scanner.next(); // Consume the invalid input
					} else { // If the next input is an integer
						itemQuantityInStock = scanner.nextInt(); // Read the item quantity
						if (itemQuantityInStock <= 0) { // If the item quantity is less than or equal to 0
							System.out.println("Invalid entry"); // Print an error message
						} else { // If the item quantity is greater than 0
							break; // Break the loop
						}
					}
				}

				// Loop until a valid cost is entered
				while (true) {
					// Prompt the user to enter the item cost
					System.out.print("Enter the cost of the item: ");
					if (!scanner.hasNextFloat()) { // If the next input is not a float
						System.out.println("Invalid entry"); // Print an error message
						scanner.next(); // Consume the invalid input
					} else { // If the next input is a float
						itemCost = scanner.nextFloat(); // Read the item cost
						if (itemCost <= 0) { // If the item cost is less than or equal to 0
							System.out.println("Invalid entry"); // Print an error message
						} else { // If the item cost is greater than 0
							break; // Break the loop
						}
					}
				}

				// Loop until a valid price is entered
				while (true) {
					// Prompt the user to enter the item price
					System.out.print("Enter the sales price of the item: ");
					if (!scanner.hasNextFloat()) { // If the next input is not a float
						System.out.println("Invalid entry"); // Print an error message
						scanner.next(); // Consume the invalid input
					} else { // If the next input is a float
						itemPrice = scanner.nextFloat(); // Read the item price
						if (itemPrice <= 0) { // If the item price is less than or equal to 0
							System.out.println("Invalid entry"); // Print an error message
						} else { // If the item price is greater than 0
							break; // Break the loop
						}
					}
				}

				scanner.nextLine(); // Consume the newline
				return true; // Return true
			} catch (InputMismatchException e) { // If an InputMismatchException is thrown
				System.out.println("Invalid entry"); // Print an error message
				scanner.next(); // Consume the invalid input
			}
		}
	}

	// Method to input the item code
	public boolean inputCode(Scanner scanner) {
		// Loop until a valid input is entered
		while (true) {
			// Prompt the user to enter the item code
			System.out.println("Enter the code for the item: <must be an int>");
			try {
				itemCode = scanner.nextInt(); // Read the item code
				return true; // Return true
			} catch (InputMismatchException e) { // If an InputMismatchException is thrown
				System.out.println("Invalid input. Please enter an integer."); // Print an error message
				scanner.next(); // Consume the invalid input
			}
		}
	}

	@Override
	public String toString() {
		return "Item: " + itemCode + " " + itemName + " " + itemQuantityInStock + " price: "
				+ "$" + String.format("%.2f", itemPrice) + " cost: $" + String.format("%.2f", itemCost);
	}
	
}
