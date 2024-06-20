import java.util.ArrayList; 
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

public class Inventory { 

	private ArrayList<FoodItem> inventory = new ArrayList<FoodItem>(); // Declaring a private ArrayList of FoodItem objects named inventory

	private int numItems; 

	public Inventory() { 
	}

	public String toString() { // Overriding the toString method for Inventory class
		StringBuilder inventoryString = new StringBuilder(); // Creating a new StringBuilder object named inventoryString
		for (FoodItem item : inventory) { // For each FoodItem object in inventory
			inventoryString.append(item.toString() + "\n"); // Append the string representation of the FoodItem object to inventoryString
		}
		return inventoryString.toString(); // Return the string representation of inventoryString
	}

	public int alreadyExists(FoodItem item) { // Defining a public method named alreadyExists that takes a FoodItem object as argument and returns an integer
		for (int i = 0; i < inventory.size(); i++) { // For each FoodItem object in inventory
			if (inventory.get(i).isEqual(item)) { // If the current FoodItem object is equal to the argument
				return i; // Return the index of the current FoodItem object
			}
		}
		return -1; // Return -1 if the item is not found in the inventory
	}

	public boolean addItem(Scanner scanner) { // Defining a public method named addItem that takes a Scanner object as argument and returns a boolean
		scanner.nextLine(); // Reading the next line of input
		System.out.println("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)? <user enters f,v, or p>"); // Printing a message to the console
		String choice = scanner.nextLine(); // Reading the next line of input and storing it in a String variable named choice

		try {
			switch (choice) { // Starting a switch-case structure based on the value of choice
			case "f": // If choice is "f"
				Fruit fruit = new Fruit(); // Creating a new Fruit object named fruit
				if (fruit.addItem(scanner)) { // If the addItem method of fruit returns true
					if (alreadyExists(fruit) != -1) { // If the fruit already exists in the inventory
						System.out.println("Error: Item with this code already exists."); // Print an error message
						return false; // Return false
					}
					inventory.add(fruit); // Add the fruit to the inventory
					numItems++; // Increment numItems
				} else {
					return false; // If the addItem method of fruit returns false, return false
				}
				break; // Breaking out of the switch-case structure

			case "v": // If choice is "v"
				Vegetable vegetable = new Vegetable(); // Creating a new Vegetable object named vegetable
				if (vegetable.addItem(scanner)) { // If the addItem method of vegetable returns true
					if (alreadyExists(vegetable) != -1) { // If the vegetable already exists in the inventory
						System.out.println("Error: Item with this code already exists."); // Print an error message
						return false; // Return false
					}
					inventory.add(vegetable); // Add the vegetable to the inventory
					numItems++; // Increment numItems
				} else {
					return false; // If the addItem method of vegetable returns false, return false
				}
				break; // Breaking out of the switch-case structure

			case "p": // If choice is "p"
				Preserve preserve = new Preserve(); // Creating a new Preserve object named preserve
				if (preserve.addItem(scanner)) { // If the addItem method of preserve returns true
					if (alreadyExists(preserve) != -1) { // If the preserve already exists in the inventory
						System.out.println("Error: Item with this code already exists."); // Print an error message
						return false; // Return false
					}
					inventory.add(preserve); // Add the preserve to the inventory
					numItems++; // Increment numItems
				} else {
					return false; // If the addItem method of preserve returns false, return false
				}
				break; // Breaking out of the switch-case structure

			default: // If choice is none of the above
				System.out.println("Invalid entry"); // Printing a message to the console
				return false; // Returning false
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid entry"); // Printing a message to the console
		}
		return true; // Returning true
	}

	public boolean updateQuantity(Scanner scanner, boolean buyOrSell) { // Defining a public method named updateQuantity that takes a Scanner object and a boolean as arguments and returns a boolean
		int amount = 0; // Declaring an integer variable named amount and initializing it to 0
		FoodItem item = new FoodItem(); // Creating a new FoodItem object named item

		if (inventory.isEmpty()) { // If the inventory is empty
			System.out.println("Error.. could not buy/sell item. Inventory is empty"); // Print an error message
			return false; // Return false
		}

		item.inputCode(scanner); // Call the inputCode method on item
		int index = alreadyExists(item); // Call the alreadyExists method with item as argument and store the result in an integer variable named index
		if (index == -1) { // If the item is not found in the inventory
			System.out.println("Item not found in inventory"); // Print an error message
			return false; // Return false
		}

		item = inventory.get(index); // Get the FoodItem object at index from inventory and store it in item

		try {
			if (buyOrSell) { // If buyOrSell is true
				System.out.println("Enter valid quantity to buy: "); // Print a message to the console
				amount = scanner.nextInt(); // Read the next integer from the input and store it in amount
				
				
				//**This is the fix I added for the sell item not properly working. I made sure to call the buy
				if (!item.updateItem(amount)) { // If the updateItem method of item returns false
					return false; // Return false
				}
				
			} else { // If buyOrSell is false
				System.out.println("Enter valid quantity to sell: "); // Print a message to the console
				amount = scanner.nextInt(); // Read the next integer from the input and store it in amount
				
				if (!item.updateItem(-amount)) { // If the updateItem method of item returns false
					return false; // Return false
				}
				
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid entry. Please enter a valid number"); // Print an error message
			scanner.nextLine(); // Read the next line of input
			return false; // Return false
		}
		return true; // Return true
	}

	public void displayInventory() { // Defining a public method named displayInventory
		System.out.println("Inventory:"); // Print a message to the console
		for (FoodItem item : inventory) { // For each FoodItem object in inventory
			System.out.println(item); // Print the string representation of the FoodItem object
		}
	}
}