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

public class Assign1 {

	public static void main(String[] args) {

		Inventory inventory = new Inventory();

		Scanner scanner = new Scanner(System.in);

		boolean exit = false;
		
		while (!exit) {
		
		try {

			displayMenu();
			int choice = scanner.nextInt();

			switch(choice) {

			case 1:
				inventory.addItem(scanner);
				break;
			case 2:
				inventory.displayInventory();
				break;
			case 3:
				if (inventory.updateQuantity(scanner, true)) {
                    System.out.println("Item bought successfully");
                }
				break;
			case 4:
				if (inventory.updateQuantity(scanner, false)) {
					System.out.println("Item sold successfully");
				}
				break;
			case 5:
				exit = true;
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("<must be a number between 1 - 5>");
				break;
			}
		} catch (InputMismatchException e) {
			System.out.println("<must be a number between 1 - 5>");
			scanner.nextLine();
		}
	}
		scanner.close();
	}

	private static void displayMenu() {
		System.out.println("\nPlease select one of the following:");
		System.out.println("1: Add Item to Inventory");
		System.out.println("2: Display Current Inventory");
		System.out.println("3: Buy Item(s)");
		System.out.println("4: Sell Item(s)");
		System.out.println("5: To Exit");
	}
}
