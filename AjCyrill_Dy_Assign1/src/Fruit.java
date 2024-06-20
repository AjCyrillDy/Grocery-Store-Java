import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * Student Name: Aj Cyrill Dy
 * Student Number: 041113696
 * Section #: 311
 * Course: CST8130 - Data Structures
 * Author/Professor: Narges Tabar
 */

public class Fruit extends FoodItem {
	
	private String orchardName;

	//No arg constructor
	public Fruit() {
	}

	@Override
	public boolean addItem(Scanner scanner) {
		if (super.addItem(scanner)) {
			try {
				System.out.print("Enter the name of the orchard supplier: ");
				orchardName = scanner.nextLine();
				return true;
			} catch (NumberFormatException e) {
				System.out.println("Invalid entry");
				return false;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return super.toString() + " orchard supplier: " + orchardName;
	}
}
